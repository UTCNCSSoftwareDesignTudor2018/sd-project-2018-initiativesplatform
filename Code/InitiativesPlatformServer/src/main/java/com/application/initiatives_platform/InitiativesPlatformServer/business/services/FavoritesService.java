package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

public interface FavoritesService {
	public void save(Project project, User user);

	public List<Favorites> getByUserName(String loggedInUserName);
}
