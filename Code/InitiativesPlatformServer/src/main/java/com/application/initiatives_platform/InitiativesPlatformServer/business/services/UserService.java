package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.UserDto;

public interface UserService {

	public User getUser(String userName);

	public UserDto getUserDto(String userName);
	
	public User registerUser(UserDto userDto);
	
	public User editProfile(UserDto userDto);
}
