package security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import exception.JobPortalException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app-jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    public String generateToken(Authentication authentication) {

        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(username)  // Correct method for setting the subject
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key())  // Sign with the secret key
                .compact();

        return token;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)); // Use decoded secret key
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())  // Correct signing key setup
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key()) // Use the correct signing key setup
                    .build()
                    .parseClaimsJws(token); // Parse the token claims
            return true;
        } catch (MalformedJwtException malformedJwtException) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "Invalid JWT Token");
        } catch (ExpiredJwtException expiredJwtException) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException unsupportedJwtException) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST, "Jwt claims string is null or empty");
        }
    }
}
