package com.akhm.service;

import java.util.List;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.UsersDTO;

public interface ResultService {
	public List<UsersDTO> getUsers();
	public UsersDTO getUser(int userId);
	public List<Posts> getUserPosts(int userId);
	public Posts getPosts(Integer postId);
	public List<Comments> getUserComments(int postId);
	public Comments getComments(Integer postId);
	public List<Todos> getUserTodos(int userId);
	public Todos getTodos(Integer userId);
	public List<Todos> getPendingTodos(int userId);
	public List<Todos> getCompletedTodos(int userId);
	public List<Albums> getUserAlbums(int userId);
	public Albums getAlbums(Integer userId);
	
}
