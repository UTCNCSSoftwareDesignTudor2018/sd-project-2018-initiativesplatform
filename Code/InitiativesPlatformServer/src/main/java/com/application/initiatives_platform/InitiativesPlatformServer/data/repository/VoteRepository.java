package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

	List<Vote> findAllByVotingUserAccountInfoUserName(String userName);
	
}
