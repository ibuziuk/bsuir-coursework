package bsuir.coursework.service;

import java.util.List;

import bsuir.coursework.model.Role;

public interface RoleService {
	void addRole(Role role);
	List<Role> getRoles();
	void removeRole(Integer id);
	Role getRoleById(Integer id);
}
