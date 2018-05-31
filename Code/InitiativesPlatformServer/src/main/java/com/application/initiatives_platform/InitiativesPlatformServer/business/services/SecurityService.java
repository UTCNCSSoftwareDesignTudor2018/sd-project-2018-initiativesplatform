package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
    
    void logout();
}
