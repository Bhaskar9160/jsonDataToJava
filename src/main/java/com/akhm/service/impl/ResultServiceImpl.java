package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.dto.UsersDTO;
import com.akhm.service.ResultService;
import com.akhm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ResultServiceImpl implements ResultService{
	@Autowired
	private UserService userService;
	@Override
	public List<UsersDTO> getUsers() {
		List<UsersDTO> usersLists=new ArrayList<UsersDTO>();
		try {
			List<User> users=userService.getUsers();
			List<Todos> todos=userService.getTodos();
			List<Posts> posts=userService.getPosts();
			List<Comments> comments=userService.getComments();
			List<Albums> albums=userService.getAlbums();
			ObjectMapper mapper=new ObjectMapper();
			
			for(User user:users) {
				UsersDTO usersDTO=new UsersDTO();
				//usersDTO.setId(user.getId());
				BeanUtils.copyProperties(user, usersDTO);
				List<Todos> userTodos=todos.stream().filter(t->t.getUserId()==user.getId()).collect(Collectors.toList());
				usersDTO.setTodosCount(userTodos.size());
				List<Todos> pendingTodos=userTodos.stream().filter(t->t.isCompleted()==false).collect(Collectors.toList());
				List<Todos> completedTodos=userTodos.stream().filter(t->t.isCompleted()==true).collect(Collectors.toList());
				usersDTO.setPendingTodosCount(pendingTodos.size());
				usersDTO.setCompletedCount(completedTodos.size());
				List<Posts> usersPosts=posts.stream().filter(p->p.getUserId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setPostCount(usersPosts.size());
				List<Comments> userComments=comments.stream().filter(c->c.getPostId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setCommentCount(userComments.size());
				List<Albums> userAlbums=albums.stream().filter(a->a.getUserId()==usersDTO.getId()).collect(Collectors.toList());
				usersDTO.setAlbumsCount(userAlbums.size());
				usersLists.add(usersDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return usersLists;
	}
	@Override
	public UsersDTO getUser(int userId) {
		
		return getUsers().stream().filter(u->u.getId()==userId).collect(Collectors.toList()).get(0);
	}
	@Override
	public List<Posts> getUserPosts(int userId) {
		
		return userService.getPosts().stream().filter(p->p.getUserId()==userId).collect(Collectors.toList());
	}
	@Override
	public Posts getPosts(Integer postId) {
		
		return userService.getPosts().stream().filter(p->p.getId()==postId).collect(Collectors.toList()).get(0);
	}
	@Override
	public List<Comments> getUserComments(int postId) {
		
		return userService.getComments().stream().filter(c->c.getPostId()==postId).collect(Collectors.toList());
	}
	@Override
	public Comments getComments(Integer postId) {
		
		return  userService.getComments().stream().filter(c->c.getId()==postId).collect(Collectors.toList()).get(0);
	}
	@Override
	public List<Todos> getUserTodos(int userId) {
		
		return userService.getTodos().stream().filter(t->t.getUserId()==userId).collect(Collectors.toList());
	}
	@Override
	public Todos getTodos(Integer userId) {
		
		return userService.getTodos().stream().filter(t->t.getId()==userId).collect(Collectors.toList()).get(0);
	}
	@Override
	public List<Todos> getPendingTodos(int userId) {
		List<Todos> todos=userService.getTodos();
		List<Todos> userTodos=todos.stream().filter(t->t.getUserId()==userId).collect(Collectors.toList());
		
		List<Todos> pendingTodos=userTodos.stream().filter(t->t.isCompleted()==false).collect(Collectors.toList());
		
		return pendingTodos;
	}
	@Override
	public List<Todos> getCompletedTodos(int userId) {
		List<Todos> todos=userService.getTodos();
List<Todos> userTodos=todos.stream().filter(t->t.getUserId()==userId).collect(Collectors.toList());
		
		List<Todos> compltedTodos=userTodos.stream().filter(t->t.isCompleted()==true).collect(Collectors.toList());
		
		return compltedTodos;
	}
	@Override
	public List<Albums> getUserAlbums(int userId) {
		
		return userService.getAlbums().stream().filter(a->a.getUserId()==userId).collect(Collectors.toList());
	}
	@Override
	public Albums getAlbums(Integer userId) {
		
		return userService.getAlbums().stream().filter(a->a.getId()==userId).collect(Collectors.toList()).get(0);
	}
	
}
