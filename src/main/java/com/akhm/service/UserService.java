package com.akhm.service;

import java.util.List;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Photos;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;

public interface UserService {
	public List<User> getUsers();
	public List<Todos> getTodos();
	public List<Posts> getPosts();
	public List<Comments> getComments();
	public List<Albums> getAlbums();
	public List<Photos>getPhotos();
}
