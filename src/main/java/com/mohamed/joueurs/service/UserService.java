package com.mohamed.joueurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mohamed.joueurs.entities.Role;
import com.mohamed.joueurs.entities.User;


public interface UserService {
	
    List <User> findAll();
	
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	void deleteUserById(Long id);
	User getUser(Long id);
	Page<User> getAllUsersParPage(int page, int size);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}