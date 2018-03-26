package com.daily.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.RolePermission;
import com.daily.model.Page;
import com.daily.service.RolePermissionService;
import com.daily.util.PageUtils;

@Controller
public class RolePermissionController {
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@RequestMapping("queryRolePermissionBypage.do")
	public String queryRolePermissionBypage(RolePermission rolePermission,Page page,ModelMap model){
		page.setMaxRows(5);
		List<RolePermission> list = rolePermissionService.queryByRolePermission(rolePermission);
		page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		List<RolePermission> rolePermissionList = rolePermissionService.queryByList(page, rolePermission);
		model.put("page", page);
		model.put("rolePermissionList", rolePermissionList);
		model.put("rolePermission", rolePermission);
		return "/rolePermission_list";
	}
	
	@RequestMapping("addRolePermission.do")
	public String addRolePermission(RolePermission rolePermission,HttpServletRequest request){
		rolePermissionService.save(rolePermission);
		return "redirect:/queryRolePermissionBypage.do";
	}
	
	
	@RequestMapping("editRolePermission.do")
	public String editRolePermission(RolePermission rolePermission,ModelMap model){
		rolePermission = rolePermissionService.queryById(rolePermission.getPermissionid());
		model.put("rolePermission", rolePermission);
		return "/rolePermission_edit";
	}
	
	@RequestMapping("updateRolePermission.do")
	public String updateRolePermission(RolePermission rolePermission,HttpServletRequest request){
		rolePermissionService.update(rolePermission);
		return "redirect:/queryRolePermissionBypage.do";
	}
	
	@RequestMapping("deleteRolePermissionByid.do")
	public String deleteRolePermissionByid(RolePermission rolePermission){
		rolePermissionService.deleteById(rolePermission.getPermissionid());
		return "redirect:/queryRolePermissionBypage.do";
	}
}
