package com.daily.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.UserRole;
import com.daily.model.Page;
import com.daily.service.UserRoleService;
import com.daily.util.PageUtils;

@Controller
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("queryUserRoleBypage.do")
	public String queryUserRoleBypage(UserRole userRole,Page page,ModelMap model){
		page.setMaxRows(5);
		List<UserRole> list = userRoleService.queryByUserRole(userRole);
		page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		List<UserRole> userRoleList = userRoleService.queryByList(page, userRole);
		model.put("page", page);
		model.put("userRoleList", userRoleList);
		model.put("userRole", userRole);
		return "/userRole_list";
	}
	
	@RequestMapping("addUserRole.do")
	public String addUserRole(UserRole userRole,HttpServletRequest request){
		userRoleService.save(userRole);
		return "redirect:/queryUserRoleBypage.do";
	}
	
	
	@RequestMapping("editUserRole.do")
	public String editUserRole(UserRole userRole,ModelMap model){
		userRole = userRoleService.queryById(userRole.getRoleid());
		model.put("userRole", userRole);
		return "/userRole_edit";
	}
	
	@RequestMapping("updateUserRole.do")
	public String updateUserRole(UserRole userRole,HttpServletRequest request){
		userRoleService.update(userRole);
		return "redirect:/queryUserRoleBypage.do";
	}
	
	@RequestMapping("deleteUserRoleByid.do")
	public String deleteUserRoleByid(UserRole userRole){
		userRoleService.deleteById(userRole.getRoleid());
		return "redirect:/queryUserRoleBypage.do";
	}
}
