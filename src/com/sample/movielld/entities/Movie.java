package com.sample.movielld.entities;

import java.util.Objects;

public class Movie {
	
	private long id;
	private String name;
	private String language;
	private String description;
	
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Movie(long id, String name, String language, String description) {
		this.id = id;
		this.name = name;
		this.language = language;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", language=" + language + ", description=" + description + "]";
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
		Movie other = (Movie) obj;
		return id == other.id;
	}
}
