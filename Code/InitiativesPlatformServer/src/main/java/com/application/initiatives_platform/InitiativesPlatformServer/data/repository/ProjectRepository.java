package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	public List<Project> findAll();

	public Page<Project> findAll(Pageable pageable);

	public Project findByName(String name);

	public List<Project> findAllByProponentAccountInfoUserName(String userName);

}
