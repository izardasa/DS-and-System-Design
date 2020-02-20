package systemdesing.moviebooking.impl;

import java.util.Date;

public class Show {
private int id;
private Date startTime;
private Date endTime;
private Movie movie;
private CinemaHall playedAt;
public CinemaHall getPlayedAt() {
	return playedAt;
}
public void setPlayedAt(CinemaHall playedAt) {
	this.playedAt = playedAt;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getStartTime() {
	return startTime;
}
public void setStartTime(Date startTime) {
	this.startTime = startTime;
}
public Date getEndTime() {
	return endTime;
}
public void setEndTime(Date endTime) {
	this.endTime = endTime;
}
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
}
