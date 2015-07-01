package bsuir.coursework.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bsuir.coursework.model.Role;
import bsuir.coursework.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listRoles(Map<String, Object> map) {
		map.put("role", new Role());
		map.put("roleList", roleService.getRoles());
		return "role";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCustomer( @Valid @ModelAttribute("role") Role role, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("roleList", roleService.getRoles());
			return "role";
		} 
		roleService.addRole(role);
		return "redirect:/role";
	}

	@RequestMapping("delete/{roleId}")
	public String deleteProject(@PathVariable("roleId") Integer roleId) {
		roleService.removeRole(roleId);
		return "redirect:/role";
	}
}
