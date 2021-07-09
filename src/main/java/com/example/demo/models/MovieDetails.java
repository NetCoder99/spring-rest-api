package com.example.demo.models;

public class MovieDetails {

    private int id;
    private String title;
    private String openingText;
    private String releaseDate;

    public MovieDetails() { }
	
    public MovieDetails(int id, String title, String openingText, String releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.openingText = openingText;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpeningText() {
		return openingText;
	}

	public void setOpeningText(String openingText) {
		this.openingText = openingText;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
