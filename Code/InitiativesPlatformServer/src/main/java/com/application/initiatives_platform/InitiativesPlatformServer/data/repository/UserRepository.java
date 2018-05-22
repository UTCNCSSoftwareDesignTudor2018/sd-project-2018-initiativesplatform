package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByAccountInfoUserName(String userName);
}
