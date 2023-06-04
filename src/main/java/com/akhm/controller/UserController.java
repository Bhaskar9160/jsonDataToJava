package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.dto.UsersDTO;
import com.akhm.service.ResultService;
import com.akhm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResultService resultService;
	@GetMapping("/users")
	public String showUsers(HttpServletRequest request) {
		List<UsersDTO> users=resultService.getUsers();
		request.setAttribute("users", users);
		return "users";
	}
	@GetMapping("/userposts/{userId}")
	public String showPosts(HttpServletRequest request,@PathVariable Integer userId) {
		UsersDTO userDTO=resultService.getUser(userId);
		List<Posts> posts=resultService.getUserPosts(userId);
		request.setAttribute("user", userDTO);
		request.setAttribute("posts", posts);
		
		return "posts";
	}
	@GetMapping("/viewpost/{id}")
	public String showPost(HttpServletRequest request,@PathVariable("id") int postId) {
		//int postId=Integer.parseInt(request.getParameter("id").trim());
		Posts post=resultService.getPosts(postId);
		UsersDTO usersDTO=resultService.getUser(post.getUserId());
		request.setAttribute("post", post);
		request.setAttribute("user", usersDTO);
		return "vpost";
	}
	@GetMapping("/usercomments/{postId}")
	public String showComments(HttpServletRequest request,@PathVariable Integer postId) {
		UsersDTO usersDTO=resultService.getUser(postId);
		List<Comments>comments=resultService.getUserComments(postId);
		request.setAttribute("user", usersDTO);
		request.setAttribute("comments", comments);
		return "comments";
	}
	@GetMapping("/viewcomment/{id}")
	public String showComment(HttpServletRequest request,@PathVariable("id") int postId) {
		//int postId=Integer.parseInt(request.getParameter("id").trim());
		Comments comment=resultService.getComments(postId);
		UsersDTO usersDTO=resultService.getUser(comment.getPostId());
		request.setAttribute("comment", comment);
		request.setAttribute("user", usersDTO);
		return "vcomment";
	}
	
	@GetMapping("/userstodos/{userId}")
	public String showTodos(HttpServletRequest request,@PathVariable Integer userId) {
		UsersDTO usersDTO=resultService.getUser(userId);
		List<Todos>todos=resultService.getUserTodos(userId);
		request.setAttribute("user", usersDTO);
		request.setAttribute("todos", todos);
		return "todos";
	}
	@GetMapping("/viewtodo/{id}")
	public String showTodo(HttpServletRequest request,@PathVariable("id") int userId) {
		Todos todo=resultService.getTodos(userId);
		UsersDTO usersDTO=resultService.getUser(todo.getUserId());
		request.setAttribute("todo", todo);
		request.setAttribute("user", usersDTO);
		return "vtodo";
	}
	
	@GetMapping("/userspendingtodos/{userId}")
	public String showPendingTodos(HttpServletRequest request,@PathVariable Integer userId) {
		UsersDTO usersDTO=resultService.getUser(userId);
		List<Todos> todos=resultService.getUserTodos(userId);
		request.setAttribute("user", usersDTO);
		request.setAttribute("todos", todos);
		return "pendingtodos";
	}
	@GetMapping("/viewpendingtodo/{id}")
	public String showPendingTodo(HttpServletRequest request,@PathVariable("id") int userId) {
		Todos todo=resultService.getTodos(userId);
		UsersDTO usersDTO=resultService.getUser(todo.getUserId());
		request.setAttribute("todo", todo);
		request.setAttribute("user", usersDTO);
		return "vpendingtodo";
	}
	
	@GetMapping("/userscompletedtodos/{userId}")
	public String showCompletedTodos(HttpServletRequest request,@PathVariable Integer userId) {
		UsersDTO usersDTO=resultService.getUser(userId);
		List<Todos> todos=resultService.getUserTodos(userId);
		request.setAttribute("user", usersDTO);
		request.setAttribute("todos", todos);
		return "completedtodos";
	}
	@GetMapping("/viewcompletedtodo/{id}")
	public String showCompletedTodo(HttpServletRequest request,@PathVariable("id") int userId) {
		Todos todo=resultService.getTodos(userId);
		UsersDTO usersDTO=resultService.getUser(todo.getUserId());
		request.setAttribute("todo", todo);
		request.setAttribute("user", usersDTO);
		return "vcompletedtodo";
	}
	
	@GetMapping("/usersalbums/{userId}")
	public String showAlbums(HttpServletRequest request,@PathVariable Integer userId) {
		UsersDTO usersDTO=resultService.getUser(userId);
		List<Albums> albums=resultService.getUserAlbums(userId);
		request.setAttribute("user", usersDTO);
		request.setAttribute("albums", albums);
		return "albums";
	}
	@GetMapping("/viewalbum/{id}")
	public String showAlbum(HttpServletRequest request,@PathVariable("id") int userId) {
		Albums album=resultService.getAlbums(userId);
		UsersDTO usersDTO=resultService.getUser(userId);
		request.setAttribute("album", album);
		request.setAttribute("user", usersDTO);
		return "valbums";
	}
}
