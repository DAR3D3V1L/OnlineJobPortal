package security;  // Adjust the package as needed

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Disable CSRF if using JWT, otherwise keep it enabled
            .authorizeRequests()
                // Allow unauthenticated access to login and sign-in endpoints
                .antMatchers("/api/auth/login", "/api/auth/signin").permitAll()
                // Any other requests must be authenticated
                .anyRequest().authenticated()
            .and()
            .formLogin().disable()  // Disable the default Spring Security login page
            .httpBasic().disable()  // Disable HTTP Basic Authentication if you're using JWT
            .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                });  // Handle unauthorized access if needed

        return http.build();  // Return the SecurityFilterChain
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password hashing
    }
}