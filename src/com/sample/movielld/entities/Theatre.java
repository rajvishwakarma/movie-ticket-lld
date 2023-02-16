package com.sample.movielld.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Theatre {
	
	private long id;
	private String name;
	private String city;
	private List<Show> shows;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	public Theatre(long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.shows = new ArrayList<>();
	}
	
	public void addShows(List<Show> shows) {
		this.shows.addAll(shows);
	}
	
	public void addShow(Show shows) {
		this.shows.add(shows);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return id == other.id;
	}
	
}
