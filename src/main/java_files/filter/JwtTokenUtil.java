package filter;

import java.util.Date;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {

    private final String SECRET_KEY = "your-secret-key"; // Use environment variables in production

    // Method to extract username from the token
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    // Method to extract UserDetails (simplified)
    public UserDetails getUserDetailsFromToken(String token) {
        String username = getUsernameFromToken(token);
        // Simulating a user; replace with your actual user fetching logic
        return User.builder().username(username).password("").roles("USER").build();
    }

    // Method to validate the token
    public boolean validateToken(String token) {
        try {
            getClaimsFromToken(token); // Parsing the token ensures validity
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to extract claims from the token
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Example method to generate a token
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
