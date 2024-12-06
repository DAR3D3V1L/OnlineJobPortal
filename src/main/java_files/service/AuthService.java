package service;

import payload.LoginDto;

public interface AuthService {


    String login(LoginDto loginDto);
}
