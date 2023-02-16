package com.sample.movielld.entities;

import java.util.Objects;
import java.util.UUID;

public class Movie {
	
	private String id;
	private String name;
	private String language;
	private String description;
	
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
	
	public Movie(String name, String language, String description) {
		this.id = UUID.randomUUID().toString();
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
