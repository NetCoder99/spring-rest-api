package com.example.demo.MovieDetailsSW.models;

public class MovieDetailsSWNew {
    private String title;
    private String openingText;
    private String releaseDate;
    
    public MovieDetailsSWNew() {}
    
	public MovieDetailsSWNew(String title, String openingText, String releaseDate) {
		super();
		this.title = title;
		this.openingText = openingText;
		this.releaseDate = releaseDate;
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
