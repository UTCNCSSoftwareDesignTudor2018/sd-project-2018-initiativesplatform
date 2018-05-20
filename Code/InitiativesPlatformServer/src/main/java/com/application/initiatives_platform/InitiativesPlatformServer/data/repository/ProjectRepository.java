package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	public List<Project> findAllByProponentAccountInfoUserName(String userName);
}
