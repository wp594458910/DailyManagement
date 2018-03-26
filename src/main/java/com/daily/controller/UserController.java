package com.daily.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.User;
import com.daily.model.Page;
import com.daily.service.UserService;
import com.daily.util.PageUtils;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("queryUserBypage.do")
	public String queryUserBypage(User user,Page page,ModelMap model){
		page.setMaxRows(5);
		List<User> list = userService.queryByUser(user);
		page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
		List<User> userList = userService.queryByList(page, user);
		model.put("page", page);
		model.put("userList", userList);
		model.put("user", user);
		return "/user_list";
	}
	
	@RequestMapping("addUser.do")
	public String addUser(User user,HttpServletRequest request){
		userService.save(user);
		return "redirect:/queryUserBypage.do";
	}
	
	
	@RequestMapping("editUser.do")
	public String editUser(User user,ModelMap model){
		user = userService.queryById(user.getId());
		model.put("user", user);
		return "/user_edit";
	}
	
	@RequestMapping("updateUser.do")
	public String updateUser(User user,HttpServletRequest request){
		userService.update(user);
		return "redirect:/queryUserBypage.do";
	}
	
	@RequestMapping("deleteUserByid.do")
	public String deleteUserByid(User user){
		userService.deleteById(user.getId());
		return "redirect:/queryUserBypage.do";
	}
}
