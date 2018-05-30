package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

public interface VoteService {
	
	public void save(Project project, User user, Campaign campaign);

}
