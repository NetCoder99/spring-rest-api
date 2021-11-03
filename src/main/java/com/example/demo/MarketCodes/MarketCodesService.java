package com.example.demo.MarketCodes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.utilities.FileReaders;
import com.example.demo.utilities.JSONUtilities;

@Service  
public class MarketCodesService {
	@Autowired  
	MarketCodesRepository marketCodesRepository; 	

	@PostConstruct
    private void postConstruct() {
		String jsonString;
		try {
			jsonString = FileReaders.getResourceFileAsString("data/marketCodes.json");
			List<MarketCodeDef> tmpObj = (List<MarketCodeDef>) new JSONUtilities<MarketCodeDef>().CreateListFromJson(jsonString, MarketCodeDef.class);				
			marketCodesRepository.saveAll(tmpObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	//public List<MarketCodeDef> loadMarketCodes() throws Exception {
	//	List<MarketCodeDef> rtnList = new ArrayList<>();  
	//	marketCodesRepository.findAll().forEach(taskDefinition -> rtnList.add(taskDefinition));
	//	return rtnList;	
	//}

	public List<MarketCodeDef> getMarketCodes() {
		List<MarketCodeDef> rtnList = new ArrayList<>();  
		marketCodesRepository.findAll().forEach(taskDefinition -> rtnList.add(taskDefinition));
		return rtnList;	
	}
}
