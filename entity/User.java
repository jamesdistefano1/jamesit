package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	private Integer numberOfPosts;
	
	public User() {
		
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public Integer getNumberOfPosts() {
		return numberOfPosts;
	}
	public void setNumberOfPosts(Integer numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}
	
	
}
