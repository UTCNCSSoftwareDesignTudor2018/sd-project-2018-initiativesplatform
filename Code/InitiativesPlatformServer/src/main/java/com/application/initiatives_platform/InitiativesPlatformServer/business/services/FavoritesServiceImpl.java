package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.FavoritesRepository;

@Service
public class FavoritesServiceImpl implements FavoritesService {
	@Autowired private FavoritesRepository favoritesRepository;
	
	@Override
	public void save(Project project, User user) {
		Favorites favorite = new Favorites(project, user);
		favoritesRepository.save(favorite);
		
	}

	@Override
	public List<Favorites> getByUserName(String userName) {
		return favoritesRepository.findAllByUserAccountInfoUserName(userName);
	}

}
