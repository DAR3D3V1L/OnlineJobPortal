package service.logic;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import payload.LoginDto;
import security.JwtTokenProvider;
import service.AuthService;

@Service
public class AuthServicelogic implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServicelogic(AuthenticationManager authenticationManager,
                            PasswordEncoder passwordEncoder,
                            JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        // Authenticate the user using the provided credentials
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(), loginDto.getPassword()));

        // Set the authentication object in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate a JWT token after successful authentication
        return jwtTokenProvider.generateToken(authentication);
    }
}
