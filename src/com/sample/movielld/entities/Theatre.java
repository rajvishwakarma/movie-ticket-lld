package com.sample.movielld.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Theatre {
	
	private String id;
	private String name;
	private String city;
	private List<Show> shows;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
	public Theatre(String name, String city) {
		this.id = UUID.randomUUID().toString();
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
	@Override
	public String toString() {
		return "Theatre [name=" + name + ", city=" + city + ", shows=" + shows + "]";
	}
}
