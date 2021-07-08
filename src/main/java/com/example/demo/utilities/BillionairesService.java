package com.example.demo.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Billionaires;

@Service  
public class BillionairesService {

	@Autowired  
	BillionairesRepository billionairesRepository; 	
	
	public List<Billionaires> getAllBillionaires()   
	{  
		List<Billionaires> rtnList = new ArrayList<Billionaires>();  
		billionairesRepository.findAll().forEach(billionaires -> rtnList.add(billionaires));
		return rtnList;
	}

}
	