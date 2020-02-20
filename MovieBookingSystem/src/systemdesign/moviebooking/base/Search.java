package systemdesign.moviebooking.base;

import java.util.Date;
import java.util.List;

import systemdesing.moviebooking.impl.Movie;

public interface Search {
public List<Movie> getMoviesByTitle(String title);
public List<Movie> getMoviesByGenre(String genre);
public List<Movie> getMoviesByReleaseDate(Date releaseDate);
public List<Movie> getMoviesByLanguage(String language);
public List<Movie> getMoviesByCity(String city);
}
