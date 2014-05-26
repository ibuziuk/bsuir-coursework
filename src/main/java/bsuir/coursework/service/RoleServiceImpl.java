package bsuir.coursework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bsuir.coursework.dao.RoleDAO;
import bsuir.coursework.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO roleDAO;

	@Override
	@Transactional
	public void addRole(Role role) {
		roleDAO.addRole(role);
	}

	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

	@Override
	@Transactional
	public void removeRole(Integer id) {
		roleDAO.removeRole(id);
	}

	@Override
	@Transactional
	public Role getRoleById(Integer id) {
		return roleDAO.getRoleById(id);
	}
}
