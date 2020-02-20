package systemdesing.moviebooking.impl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Movie {
private String title;
private int durationInMinutes;
private String description;
private String genre;
private String language;
private Date releasedDate;

public List<Show> getShows(){return null;}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getDuration() {
	return durationInMinutes;
}

public void setDuration(int duration) {
	this.durationInMinutes = duration;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public Date getReleasedDate() {
	return releasedDate;
}

public void setReleasedDate(Date releasedDate) {
	this.releasedDate = releasedDate;
};
}
