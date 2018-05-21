package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

public interface UserService {

	public void save(User user);

	public User findByUsername(String username);
}
