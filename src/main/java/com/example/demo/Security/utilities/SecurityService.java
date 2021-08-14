package com.example.demo.Security.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Security.models.LoginFields;

@Service  
public class SecurityService {

	@Autowired  
	SecurityRepository securityRepository; 	
	
	public int loadInitUsers(List<LoginFields> loginFields) {
		int usersCount = ((Long) securityRepository.count()).intValue();
		if (usersCount > 0) {delAllUsers();}
		securityRepository.saveAll(loginFields);
		return ((Long) securityRepository.count()).intValue(); 
	}
	
	public int addUser(LoginFields loginFields) {
		securityRepository.save(loginFields);
		return 1;
	}


	public LoginFields getUser(int userId) {
		return securityRepository.findById(userId).orElse(null);
	}
	public List<LoginFields> getAllUsers() {
		List<LoginFields> rtnList = new ArrayList<>();  
		securityRepository.findAll().forEach(movieDetailsSWRoot -> rtnList.add(movieDetailsSWRoot));
		if (rtnList.size() > 0) {
			return rtnList;	
		}
		else {
			return null;
		} 
	}
	

	public void delUsers(int userId) {
		securityRepository.deleteById(userId);
	}
	public int delAllUsers() {
		int usersCount = ((Long) securityRepository.count()).intValue();
		securityRepository.deleteAll();
		return usersCount;
	}


}
