package com.application.initiatives_platform.InitiativesPlatformServer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
