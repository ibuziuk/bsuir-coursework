package bsuir.coursework.dao;

import java.util.List;

import bsuir.coursework.model.Role;

public interface RoleDAO {
	void addRole(Role role);

	List<Role> getRoles();

	void removeRole(Integer id);

	Role getRoleById(Integer id);
}
