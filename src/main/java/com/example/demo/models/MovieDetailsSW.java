package com.example.demo.models;

import java.util.Date;
import java.util.List;

////import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
////import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
///* ObjectMapper om = new ObjectMapper();
//Root root = om.readValue(myJsonString), Root.class); */

public class MovieDetailsSW {
	public class Root{
	    public int count;
	    public Object next;
	    public Object previous;
	    public List<Result> results;
	}
	public class Result{
	    public String title;
	    public int episode_id;
	    public String opening_crawl;
	    public String director;
	    public String producer;
	    public String release_date;
	    public List<String> characters;
	    public List<String> planets;
	    public List<String> starships;
	    public List<String> vehicles;
	    public List<String> species;
	    public Date created;
	    public Date edited;
	    public String url;
	}

}
