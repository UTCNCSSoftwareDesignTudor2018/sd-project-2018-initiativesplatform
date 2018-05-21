package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByAccountInfoUserName(String userName);
}
