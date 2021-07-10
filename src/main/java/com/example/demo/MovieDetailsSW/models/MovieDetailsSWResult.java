package com.example.demo.MovieDetailsSW.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MovieDetailsSWResult {
	@Id	@Column @GeneratedValue(strategy=GenerationType.AUTO) int id;
	
    private String title;
    private int episode_id;
    @Column(name = "opening_crawl", length = 5000)  private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    @Column @ElementCollection(targetClass=String.class) 
    private List<String> characters;
    @Column @ElementCollection(targetClass=String.class) 
    private List<String> planets;
    @Column @ElementCollection(targetClass=String.class) 
    private List<String> starships;
    @Column @ElementCollection(targetClass=String.class) 
    private List<String> vehicles;
    @Column @ElementCollection(targetClass=String.class) 
    private List<String> species;
    private Date created;
    private Date edited;
    private String url;
    
    public MovieDetailsSWResult() {}
    
	public MovieDetailsSWResult(String title, int episode_id, String opening_crawl, String director, String producer,
			String release_date, List<String> characters, List<String> planets, List<String> starships,
			List<String> vehicles, List<String> species, Date created, Date edited, String url) {
		super();
		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.characters = characters;
		this.planets = planets;
		this.starships = starships;
		this.vehicles = vehicles;
		this.species = species;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<String> getPlanets() {
		return planets;
	}

	public void setPlanets(List<String> planets) {
		this.planets = planets;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getEdited() {
		return edited;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
	
	
    
}
