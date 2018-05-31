package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Vote;

public interface VoteService {
	
	public void save(Project project, User user, Campaign campaign);

	public List<Vote> getByUserName(String userName);

}
