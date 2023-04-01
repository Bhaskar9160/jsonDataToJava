package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Photos;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<User> getUsers() {
		try {
		String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
	    ObjectMapper objectMapper=new ObjectMapper();
		CollectionType listType = 
	      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
	    List<User> userList = objectMapper.readValue(jsonString, listType);


		
		return userList;
		}catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<User>();
		}
	}
	@Override
	public List<Todos> getTodos() {
		try {
			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
		    ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType = 
		      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Todos.class);
		    List<Todos> todosList = objectMapper.readValue(jsonString, listType);


			
			return todosList;
			}catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Todos>();
			}
		
	}
	@Override
	public List<Posts> getPosts() {
		try {
			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
		    ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType = 
		      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Posts.class);
		    List<Posts> postsList = objectMapper.readValue(jsonString, listType);


			
			return postsList;
			}catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Posts>();
			}
		
	}
	@Override
	public List<Comments> getComments() {
		try {
			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", String.class);
		    ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType = 
		      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Comments.class);
		    List<Comments> commentsList = objectMapper.readValue(jsonString, listType);


			
			return commentsList;
			}catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Comments>();
			}
		
	}
	@Override
	public List<Albums> getAlbums() {
		try {
			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", String.class);
		    ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType = 
		      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Albums.class);
		    List<Albums> albumsList = objectMapper.readValue(jsonString, listType);


			
			return albumsList;
			}catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Albums>();
			}
	}
	@Override
	public List<Photos> getPhotos() {
		try {
			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", String.class);
		    ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType = 
		      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Photos.class);
		    List<Photos> photosList = objectMapper.readValue(jsonString, listType);


			
			return photosList;
			}catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Photos>();
			}
		
	}

}
