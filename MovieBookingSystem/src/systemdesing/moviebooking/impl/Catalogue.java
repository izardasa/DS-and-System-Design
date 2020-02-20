package systemdesing.moviebooking.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import systemdesign.moviebooking.base.Search;

public class Catalogue implements Search{

	private HashMap<String,List<Movie>> movieByTitle;
	private HashMap<String,List<Movie>> movieByCity;
	private HashMap<String,List<Movie>> movieByLanguage;
	private HashMap<Date,List<Movie>> movieByDate;
	private HashMap<String,List<Movie>> movieByGenre;
	@Override
	public List<Movie> getMoviesByTitle(String title) {
		return movieByTitle.get(title);
	}

	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		return movieByGenre.get(genre);
	}

	@Override
	public List<Movie> getMoviesByReleaseDate(Date releaseDate) {
		return movieByDate.get(releaseDate);
	}

	@Override
	public List<Movie> getMoviesByLanguage(String language) {
		return movieByLanguage.get(language);
	}

	@Override
	public List<Movie> getMoviesByCity(String city) {
		return movieByCity.get(city);
	}

}
