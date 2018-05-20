package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.CategoryRepository;

@Service	
public class CategoryService {
	@Autowired CategoryRepository categoryRepository;
	
	public List<Category> save(String name, String shortDescription) {
		Category category = new Category(name, shortDescription, UUID.randomUUID().toString());
		categoryRepository.save(category);
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public List<Category> findAll() {
		Category c1 = new Category("name1", "description1", "code1");
		Category c2 = new Category("name2", "description2", "code2");
		List<Category> categories = new ArrayList<Category>();
		categories.add(c1);
		categories.add(c2);
		return categories;
	}
	
	public Category getCategory(String categoryName) {
		return null;
	}
}
