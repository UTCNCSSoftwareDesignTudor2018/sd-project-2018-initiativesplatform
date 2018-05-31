package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

	List<Favorites> findAllByUserAccountInfoUserName(String userName);

}
