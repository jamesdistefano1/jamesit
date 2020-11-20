package com.example.demo.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.PostingService;

@RestController
@Validated
@RequestMapping(value = "jamesit")
public class PostAPI {
	
	@Autowired
	PostingService postingService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value = "/user")
	public ResponseEntity addUser(@Valid @RequestBody UserDTO userDTO){
		String username = postingService.createNewProfile(userDTO);
		String message = "Success";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	//@PostMapping(value = "/{username}/{postNumber}")
	//public ResponseEntity addPost(@Valid @RequestBody PostDTO postDTO){
		
	//}
	/*
	@DeleteMapping
	public ResponseEntity deletePost(){
		
	}
	@DeleteMapping
	public ResponseEntity deleteUser() {
		
	}*/
}
