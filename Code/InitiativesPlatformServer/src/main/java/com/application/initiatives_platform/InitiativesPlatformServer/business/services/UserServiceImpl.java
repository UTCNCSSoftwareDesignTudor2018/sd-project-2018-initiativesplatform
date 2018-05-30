package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.sql.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.AccountInfo;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.PersonalInfo;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.UserType;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.RoleRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.UserRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User getUser(String userName) {
		return this.userRepository.findByAccountInfoUserName(userName);
	}

	public User registerUser(UserDto userDto) {

		User alreadyInUser = userRepository.findByAccountInfoUserName(userDto.getUserName());

		if (alreadyInUser != null) {
			return null;
		}

		User userToRegister = createUserEntity(userDto);

		userToRegister.setPassword(bCryptPasswordEncoder.encode(userToRegister.getPassword()));
		userToRegister.setRoles(new HashSet<>(roleRepository.findAll()));
		
		this.userRepository.save(userToRegister);

		return userToRegister;
	}

	private User createUserEntity(UserDto userDto) {
		PersonalInfo pInfo = new PersonalInfo();
		pInfo.setFirstName(userDto.getFirstName());
		pInfo.setLastName(userDto.getLastName());
		pInfo.setIdNumber(userDto.getIdNumber());
		pInfo.setEmail(userDto.getEmail());
		pInfo.setPhone(userDto.getPhone());
		pInfo.setAddress(userDto.getAddress());

		AccountInfo aInfo = new AccountInfo();
		aInfo.setUserName(userDto.getUserName());
		aInfo.setPassword(userDto.getPassword());
		aInfo.setUserType(UserType.REGISTERED_USER.type);

		User user = new User(pInfo, aInfo);
		user.setVersion(Long.valueOf(1));
		user.setTimeStamp(new Date(System.currentTimeMillis()));
		
		return user;
	}
	
	public void save(User user) {}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByAccountInfoUserName(username);
	}
}
