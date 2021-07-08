package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Billionaires;
import com.example.demo.models.Customer;
import com.example.demo.models.ErrorResponse;
import com.example.demo.models.LocalToken;
import com.example.demo.models.LoginFields;
import com.example.demo.utilities.BillionairesRepository;
import com.example.demo.utilities.BillionairesService;
import com.example.demo.utilities.FileReaders;
import com.example.demo.utilities.JSONUtilities;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController<T> {
	@Autowired BillionairesService billionairesService; 	
	
	@RequestMapping(value="/version", method = { RequestMethod.GET, RequestMethod.POST })
	public String version() {
		String version = "Version: 1.0.1";
		System.out.println("version:" + version);
		return version;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<T> login(@RequestBody String requestBody, @RequestParam(required = false, defaultValue = "login") String apiKey) throws Exception {
		System.out.println("login apiKey:" + apiKey);
		System.out.println("login request:" + requestBody);
		Thread.sleep(1000);
		LoginFields loginFields = JSONUtilities.getLoginFields(requestBody);
		return (ResponseEntity<T>) new ResponseEntity<LocalToken>(new LocalToken("Test3456"), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<T>  signup(@RequestBody String requestBody, @RequestParam(required = false, defaultValue = "signup") String apiKey) throws Exception {
		try {
			System.out.println("signup apiKey:" + apiKey);
			System.out.println("signup request:" + requestBody);
			Thread.sleep(2000);
			LoginFields loginFields = JSONUtilities.getLoginFields(requestBody);

			if (loginFields.getPassWord().length() < 2)
			{ throw new Exception("Very weak password:"); }

			if (loginFields.getPassWord().length() < 5)
			{
				return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, "Weak password."), HttpStatus.BAD_REQUEST);
			}
			
			return (ResponseEntity<T>) new ResponseEntity<LocalToken>(new LocalToken("Test3456"), HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("signup failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/getData")
	@SuppressWarnings({ "unchecked" })
	public List<Customer> getData() throws Exception {
		String jsonString = FileReaders.getResourceFileAsString("data/MOCK_DATA.json");
		return (List<Customer>) (List<?>) new JSONUtilities<>().GetFromJsonList(jsonString, Customer.class); 
	}

	@GetMapping("/getBillionaires")
	//http://localhost:8081/getBillionaires
	public List<Billionaires> getBillionaires() throws Exception {
		List<Billionaires> rtnList = billionairesService.getAllBillionaires();
		return rtnList;
	}
}
