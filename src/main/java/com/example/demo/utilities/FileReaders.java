package com.example.demo.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileReaders {

	public static String getResourceFileAsString(String fileName) throws Exception {
		
		//File file = new ClassPathResource(fileName).getFile();
		
	    InputStream is = getResourceFileAsInputStream(fileName);
	    if (is != null) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        return (String)reader.lines().collect(Collectors.joining(System.lineSeparator()));
	    } else {
	        throw new RuntimeException("resource not found");
	    }
	}

	public static InputStream getResourceFileAsInputStream(String fileName) {
	    ClassLoader classLoader = FileReaders.class.getClassLoader();
	    return classLoader.getResourceAsStream(fileName);
	}

}
