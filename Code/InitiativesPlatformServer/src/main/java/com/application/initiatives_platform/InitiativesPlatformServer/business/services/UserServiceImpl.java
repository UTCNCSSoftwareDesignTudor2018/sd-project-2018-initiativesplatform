package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.AccountInfo;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.PersonalInfo;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.UserType;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Vote;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.RoleRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.UserRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.ProjectDto;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired private ProjectService projectService;
	@Autowired private VoteService voteService;
	@Autowired private FavoritesService favoritesService;
	
	@Override
	public User getUser(String userName) {
		return this.userRepository.findByAccountInfoUserName(userName);
	}
	
	@Override
	public UserDto getUserDto(String userName) {
		User user = this.userRepository.findByAccountInfoUserName(userName);
		return createUserDto(user);
	}

	@Override
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
	
	@Override
	public User editProfile(UserDto userDto) {
		User oldUserProfile = this.userRepository.findByAccountInfoUserName(userDto.getUserName());
		User newUserProfile = this.createUserEntity(userDto);
		newUserProfile.setUserName(oldUserProfile.getUserName());
		if (userDto.getPassword() != null) {
			newUserProfile.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		} else {
			newUserProfile.setPassword(oldUserProfile.getPassword());
		}
		userRepository.delete(oldUserProfile);
		return userRepository.save(newUserProfile);
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
	
	private UserDto createUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setIdNumber(user.getIdNumber());
		userDto.setEmail(user.getEmail());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddress());
		userDto.setUserName(user.getUserName());
		userDto.setPassword("");
		return userDto;
	}

	public List<ProjectDto> getProposedProjects(String loggedInUserName) {
		List<Project> proposedProjects = projectService.findAllByProponentUserName(loggedInUserName);
		return proposedProjects.stream().map(p -> new ProjectDto(p)).collect(Collectors.toList());
	}

	public List<ProjectDto> getVotedProjects(String loggedInUserName) {
		List<Vote> votes = voteService.getByUserName(loggedInUserName);
		return votes.stream().map(v -> new ProjectDto(v.getVotedProject())).collect(Collectors.toList());
	}

	public List<ProjectDto> getFavoriteProjects(String loggedInUserName) {
		List<Favorites> favorites = favoritesService.getByUserName(loggedInUserName);
		return favorites.stream().map(f -> new ProjectDto(f.getProject())).collect(Collectors.toList());
	}
}
