package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.CampaignRepository;

@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired CampaignRepository campaignRepository;
	
	@Override
	public Campaign getCurrentCampaign() {
		List<Campaign> campaigns = campaignRepository.findAll();
		if(campaigns.size() == 0) {
			return null;
		}
		return campaigns.get(0);
	}

}
