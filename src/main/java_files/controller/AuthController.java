package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payload.JWTResponseDto;
import payload.LoginDto;
import service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Constructor injection of AuthService
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    // Handle POST requests for login or signin (AJAX-based)
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTResponseDto> authenticateUser(@RequestBody LoginDto loginDto) {
        // Call service to authenticate the user and get the JWT token
        String token = authService.login(loginDto);
        
        // Prepare the response with the token and the type "Bearer"
        JWTResponseDto jwtResponseDto = new JWTResponseDto(token, "Bearer");
        
        // Return the response with status 200 (OK)
        return ResponseEntity.ok(jwtResponseDto);
    }
}
f