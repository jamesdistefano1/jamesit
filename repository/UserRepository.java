package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;

public interface UserRepository extends CrudRepository<User, String>{
	public List<Post> findAllPostsByUser(User user);
}
