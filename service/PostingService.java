package com.example.demo.service;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.exception.PostException;
import com.example.demo.exception.UserException;

public interface PostingService {
	public String createNewProfile(UserDTO userDTO);
	
	public String deleteProfile(UserDTO userDTO) throws UserException;
	
	public Integer addNewPost(PostDTO postDTO) throws UserException;
	
	public String deletePost(PostDTO postDTO) throws PostException;
	
	public String deletePost(Post post);
}
