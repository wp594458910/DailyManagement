package com.daily.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.Permission;
import com.daily.model.Page;
import com.daily.service.PermissionService;
import com.daily.util.PageUtils;

@Controller
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("queryPermissionBypage.do")
	public String queryPermissionBypage(Permission permission,Page page,ModelMap model){
		page.setMaxRows(5);
		List<Permission> list = permissionService.queryByPermission(permission);
		page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		List<Permission> permissionList = permissionService.queryByList(page, permission);
		model.put("page", page);
		model.put("permissionList", permissionList);
		model.put("permission", permission);
		return "/permission_list";
	}
	
	@RequestMapping("addPermission.do")
	public String addPermission(Permission permission,HttpServletRequest request){
		permissionService.save(permission);
		return "redirect:/queryPermissionBypage.do";
	}
	
	
	@RequestMapping("editPermission.do")
	public String editPermission(Permission permission,ModelMap model){
		permission = permissionService.queryById(permission.getId());
		model.put("permission", permission);
		return "/permission_edit";
	}
	
	@RequestMapping("updatePermission.do")
	public String updatePermission(Permission permission,HttpServletRequest request){
		permissionService.update(permission);
		return "redirect:/queryPermissionBypage.do";
	}
	
	@RequestMapping("deletePermissionByid.do")
	public String deletePermissionByid(Permission permission){
		permissionService.deleteById(permission.getId());
		return "redirect:/queryPermissionBypage.do";
	}
}
