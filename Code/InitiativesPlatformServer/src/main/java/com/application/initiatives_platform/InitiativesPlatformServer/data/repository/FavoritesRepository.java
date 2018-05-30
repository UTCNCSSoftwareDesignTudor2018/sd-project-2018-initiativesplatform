package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

}
