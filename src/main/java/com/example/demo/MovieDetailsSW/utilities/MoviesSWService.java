package com.example.demo.MovieDetailsSW.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MovieDetailsSW.models.MovieDetailsSWNew;
import com.example.demo.MovieDetailsSW.models.MovieDetailsSWResult;
import com.example.demo.MovieDetailsSW.models.MovieDetailsSWRoot;

@Service  
public class MoviesSWService {

	@Autowired  
	MoviesSWRepository moviesSWRepository; 	

	public int loadInitMovies(MovieDetailsSWRoot movieDetailsSWRoot) {
		int movieCount = ((Long) moviesSWRepository.count()).intValue();
		if (movieCount > 0) {delMovies();}
		
		moviesSWRepository.save(movieDetailsSWRoot);
		
		return movieCount; 
	}
	
	public MovieDetailsSWRoot getMovies() {
		List<MovieDetailsSWRoot> rtnList = new ArrayList<>();  
		moviesSWRepository.findAll().forEach(movieDetailsSWRoot -> rtnList.add(movieDetailsSWRoot));
		if (rtnList.size() > 0) {
			return rtnList.get(0);	
		}
		else {
			return null;
		} 
	}
	
	public int addMovie(MovieDetailsSWNew movieDetailsSWNew) {
		MovieDetailsSWResult movieDetailsSWResult = new  MovieDetailsSWResult();
		movieDetailsSWResult.setTitle(movieDetailsSWNew.getTitle());
		movieDetailsSWResult.setRelease_date(movieDetailsSWNew.getReleaseDate());
		movieDetailsSWResult.setOpening_crawl(movieDetailsSWNew.getOpeningText());
		
		MovieDetailsSWRoot movieSWRoot = null;
		
		List<MovieDetailsSWRoot> rtnList = new ArrayList<>();  
		moviesSWRepository.findAll().forEach(movieDetailsSWRoot -> rtnList.add(movieDetailsSWRoot));
		if (rtnList.size() > 0) {
			movieSWRoot = rtnList.get(0);
			movieSWRoot.getResults().add(movieDetailsSWResult);
			moviesSWRepository.save(movieSWRoot);
		}

		//moviesSWRepository.
		//moviesSWRepository.(movieDetailsSWResult);
		
		return 1;
	}

	public int delMovies() {
		int movieCount = ((Long) moviesSWRepository.count()).intValue();
		moviesSWRepository.deleteAll();
		return movieCount;
	}

}
