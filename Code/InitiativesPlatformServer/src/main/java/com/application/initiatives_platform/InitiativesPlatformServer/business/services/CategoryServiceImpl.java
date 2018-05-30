package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.CategoryRepository;

@Service	
public class CategoryServiceImpl implements CategoryService {
	@Autowired CategoryRepository categoryRepository;
	
	public List<Category> save(String name, String shortDescription) {
		Category category = new Category(name, shortDescription, UUID.randomUUID().toString());
		categoryRepository.save(category);
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public List<Category> findAll() {
		
		List<Category> categories = categoryRepository.findAll();
		
		return categories;
	}
	
	public Category getCategory(String categoryName) {
		Optional<Category> category = categoryRepository.findByName(categoryName);
		return category.get();
	}
}
