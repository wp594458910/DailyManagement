package com.daily.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.Role;
import com.daily.model.Page;
import com.daily.service.RoleService;
import com.daily.util.PageUtils;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("queryRoleBypage.do")
	public String queryRoleBypage(Role role,Page page,ModelMap model){
		page.setMaxRows(5);
		List<Role> list = roleService.queryByRole(role);
		page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		List<Role> roleList = roleService.queryByList(page, role);
		model.put("page", page);
		model.put("roleList", roleList);
		model.put("role", role);
		return "/role_list";
	}
	
	@RequestMapping("addRole.do")
	public String addRole(Role role,HttpServletRequest request){
		roleService.save(role);
		return "redirect:/queryRoleBypage.do";
	}
	
	
	@RequestMapping("editRole.do")
	public String editRole(Role role,ModelMap model){
		role = roleService.queryById(role.getId());
		model.put("role", role);
		return "/role_edit";
	}
	
	@RequestMapping("updateRole.do")
	public String updateRole(Role role,HttpServletRequest request){
		roleService.update(role);
		return "redirect:/queryRoleBypage.do";
	}
	
	@RequestMapping("deleteRoleByid.do")
	public String deleteRoleByid(Role role){
		roleService.deleteById(role.getId());
		return "redirect:/queryRoleBypage.do";
	}
}
