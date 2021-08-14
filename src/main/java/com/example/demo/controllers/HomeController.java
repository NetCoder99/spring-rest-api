package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MovieDetailsSW.models.MovieDetailsSWNew;
import com.example.demo.MovieDetailsSW.models.MovieDetailsSWRoot;
import com.example.demo.MovieDetailsSW.utilities.MoviesSWService;
import com.example.demo.Security.models.LocalToken;
import com.example.demo.Security.models.LoginFields;
import com.example.demo.Security.models.UpdateUserFields;
import com.example.demo.models.Billionaires;
import com.example.demo.models.Customer;
import com.example.demo.models.ErrorResponse;

import com.example.demo.utilities.BillionairesRepository;
import com.example.demo.utilities.BillionairesService;
import com.example.demo.utilities.FileReaders;
import com.example.demo.utilities.JSONUtilities;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController<T> {
	@Autowired BillionairesService billionairesService; 	
	@Autowired MoviesSWService     moviesSWService; 	
	
	private int verCounter = 0;
	
	@RequestMapping(value="/version", method = { RequestMethod.GET, RequestMethod.POST })
	public String version() {
		String version = "Version: 1.0.1::" + verCounter++;
		System.out.println("version:" + version);
		return version;
	}

	@RequestMapping(value="/version2", method = { RequestMethod.GET, RequestMethod.POST })
	public String version2(
			@RequestHeader(required = true, defaultValue = "test") String apiKey			
		) {
		String version = "Version: 1.0.1::" + verCounter++ + "::" + apiKey;
		System.out.println("version:" + version);
		return version;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<T> login(
			@RequestBody String requestBody, 
			@RequestParam(required = false, defaultValue = "queryKey") String queryKey,
			@RequestHeader(required = true, defaultValue = "headerKey") String headerKey			
			) throws Exception {
		try {
			System.out.println("login apiKey:" + headerKey);
			//System.out.println("login request:" + requestBody);
			Thread.sleep(1500);
			LoginFields loginFields = (LoginFields) new JSONUtilities<LoginFields>().CreateObjFromJson(requestBody, LoginFields.class);
			if (!loginFields.getUserName().contentEquals(headerKey)) {
				return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, "Invalid User Name"), HttpStatus.BAD_REQUEST);
			//	//throw new Exception("Invalid User Name.");
			}
			return (ResponseEntity<T>) new ResponseEntity<LocalToken>(new LocalToken("Test3456:"+verCounter++), HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("login failed:" + ex.getLocalizedMessage());
			//ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<T>  signup(@RequestBody String requestBody, @RequestParam(required = false, defaultValue = "signup") String apiKey) throws Exception {
		try {
			System.out.println("signup apiKey:" + apiKey);
			//System.out.println("signup request:" + requestBody);
			Thread.sleep(500);
			LoginFields loginFields = (LoginFields) new JSONUtilities<LoginFields>().CreateObjFromJson(requestBody, LoginFields.class);
			//LoginFields loginFields = JSONUtilities.getLoginFields(requestBody);

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

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/update", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<T> update(
			@RequestHeader(required = true) String apiKey,
			@RequestBody String requestBody 
		) throws Exception {
		try {
			System.out.println("update apiKey:" + apiKey);
			Thread.sleep(500);
			UpdateUserFields loginFields = (UpdateUserFields) new JSONUtilities<UpdateUserFields>().CreateObjFromJson(requestBody, UpdateUserFields.class);
			if (!apiKey.contentEquals("Test3456")) {
				return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, "Invalid token."), HttpStatus.BAD_REQUEST);
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
		return (List<Customer>) (List<?>) new JSONUtilities<Customer>().CreateListFromJson(jsonString, Customer.class); 
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getMovies")
	public ResponseEntity<T> getMovies() throws Exception {
		try {
			//throw new Exception("Test Exception in getMovies");
			Thread.sleep(500);
			MovieDetailsSWRoot rtnObj2 = moviesSWService.getMovies();
			if (rtnObj2 == null) {
				String jsonString = FileReaders.getResourceFileAsString("data/moviesSW.json");
				MovieDetailsSWRoot tmpObj = (MovieDetailsSWRoot) new JSONUtilities<MovieDetailsSWRoot>().CreateObjFromJson(jsonString, MovieDetailsSWRoot.class);				
				moviesSWService.loadInitMovies(tmpObj);
			}
			rtnObj2 = moviesSWService.getMovies();
			return (ResponseEntity<T>) new ResponseEntity<MovieDetailsSWRoot>(rtnObj2, HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("getMovies.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/delMovies")
	public ResponseEntity<T> delMovies() throws Exception {
		try {
			int movieCount = moviesSWService.delMovies();
			return (ResponseEntity<T>) new ResponseEntity<String>(movieCount + " movies were deleted.", HttpStatus.OK);
		}
		catch(Exception ex) {
			System.out.println("getMovies.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addMovie", method = { RequestMethod.POST })
	public ResponseEntity<T> addMovie(@RequestBody String requestBody) throws Exception {
		try {
			//throw new Exception("Add movie function not implemented");
		
			MovieDetailsSWNew tmpObj = (MovieDetailsSWNew) new JSONUtilities<MovieDetailsSWNew>().CreateObjFromJson(requestBody, MovieDetailsSWNew.class);				
			moviesSWService.addMovie(tmpObj);
			return (ResponseEntity<T>) new ResponseEntity<String>("Movie was added", HttpStatus.OK);

		}
		catch(Exception ex) {
			System.out.println("getMovies.failed:" + ex.getLocalizedMessage());
			ex.printStackTrace();
			return (ResponseEntity<T>) new ResponseEntity<ErrorResponse>(new ErrorResponse(1, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getBillionaires")
	//http://localhost:8081/getBillionaires
	public List<Billionaires> getBillionaires() throws Exception {
		List<Billionaires> rtnList = billionairesService.getAllBillionaires();
		return rtnList;
	}
}
