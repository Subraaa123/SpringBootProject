package com.mohamed.joueurs.service;

import java.util.List;

import com.mohamed.joueurs.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}