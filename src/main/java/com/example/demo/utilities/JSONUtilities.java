package com.example.demo.utilities;

import java.util.List;

import com.example.demo.models.LoginFields;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtilities<T> {

	@SuppressWarnings({ "rawtypes" })
	public List<T> GetFromJsonList(String jsonString,  Class inpClazz) throws Exception
	{
		ObjectMapper objectMapper = new ObjectMapper();
		List<T> rtnList = objectMapper.readValue(jsonString, new TypeReference<List<T>>(){});
		return rtnList;
	}

	public static LoginFields getLoginFields(String jsonString) throws Exception
	{
		ObjectMapper objectMapper = new ObjectMapper();
		LoginFields rtnObj = objectMapper.readValue(jsonString, new TypeReference<LoginFields>(){});
		return rtnObj;
	}

}
