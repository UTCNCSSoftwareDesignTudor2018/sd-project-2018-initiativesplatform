package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;

public interface CategoryService {
	public List<Category> save(String name, String shortDescription);

	public List<Category> findAll();
	
	public Category getCategory(String categoryName);
}
