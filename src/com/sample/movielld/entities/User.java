package com.sample.movielld.entities;

import java.util.Objects;
import java.util.UUID;

public class User {
	
	private String id;
	private String name;
	
	public User(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
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
		User other = (User) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
