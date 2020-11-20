package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.exception.PostException;
import com.example.demo.exception.UserException;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;


@Service
@Transactional
public class PostingServiceImpl implements PostingService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@Override
	public String createNewProfile(UserDTO userDTO) {
		User user = new User();
		user.setNumberOfPosts(userDTO.getNummberOfPosts());
		user.setUserName(userDTO.getUsername());
		userRepository.save(user);
		return user.getUserName();
	}

	@Override
	public String deleteProfile(UserDTO userDTO) throws UserException {
		Optional<User> userOptional = userRepository.findById(userDTO.getUsername());
		User user = userOptional.orElseThrow(()->new UserException("User invalid"));
		List<Post> postsByUser = userRepository.findAllPostsByUser(user);
		for(Post p: postsByUser) {
			deletePost(p);
		}
		String un = user.getUserName();
		userRepository.delete(user);
		return un;
	}

	@Override
	public Integer addNewPost(PostDTO postDTO) throws UserException {
		UserDTO userDTO = postDTO.getUserDTO();
		Optional<User> userOptional = userRepository.findById(userDTO.getUsername());
		User user = userOptional.orElseThrow(()->new UserException("User does not exist"));
		Post post = new Post();
		post.setPostNumber(postDTO.getPostNumber());
		post.setUser(user);
		postRepository.save(post);
		return post.getPostNumber();
	}

	@Override
	public String deletePost(PostDTO postDTO) throws PostException {
		Optional<Post> postOptional = postRepository.findById(postDTO.getPostNumber());
		Post post = postOptional.orElseThrow(()->new PostException("Invalid post"));
		String answer = post.getUser().getUserName();
		postRepository.delete(post);
		return answer;
	}

	@Override
	public String deletePost(Post post) {
		String answer = post.getUser().getUserName();
		postRepository.delete(post);
		return answer;
	}

	

}
