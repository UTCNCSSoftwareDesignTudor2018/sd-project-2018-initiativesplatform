package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Vote;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {
	@Autowired private VoteRepository voteRepository;
	
	@Override
	public void save(Project project, User user, Campaign campaign) {
		
		Vote vote = new Vote(project, user, campaign);
		
		voteRepository.save(vote);
	
	}
	
}
