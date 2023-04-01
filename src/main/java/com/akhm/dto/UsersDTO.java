package com.akhm.dto;

import lombok.Data;

@Data
public class UsersDTO {
	private int id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	private int postCount;
	private int commentCount;
	private int todosCount;
	private int pendingTodosCount;
	private int completedCount;
	private int albumsCount;
}
