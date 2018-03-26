package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.UserMapper;
import com.daily.model.Permission;
import com.daily.model.Role;
import com.daily.model.User;
import com.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private PasswordHelper passwordHelper;

    public Integer save(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return mapper.save(user);
    }

    public void update(User user) {
        mapper.update(user);
    }

    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    public int queryByCount(User user) {
        return mapper.queryByCount(user);
    }

    public List<User> queryByList(Page page, User user) {
        String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("username", user.getUsername());
        paramsMap.put("password", user.getPassword());
        paramsMap.put("salt", user.getSalt());
        paramsMap.put("locked", user.getLocked());
        paramsMap.put("pageQueryCondition", pageQueryCondition);
        return mapper.queryByList(paramsMap);
    }

    public List<User> queryByUser(User user) {
        return mapper.queryByUser(user);
    }

    public User queryById(Integer id) {
        return mapper.queryById(id);
    }

    public User findByUsername(String username) {
        return mapper.findByUsername(username);
    }

    public Set<String> findRoles(String username) {
        Set<String> roles = new HashSet<String>();
        List<Role> roleList = mapper.findRoles(username);
        for(Role r : roleList){
            roles.add(r.getRole());
        }
        return roles;
    }

    public Set<String> findPermissions(String username) {
        Set<String> permissions = new HashSet<String>();
        List<Permission> permissionList = mapper.findPermissions(username);
        for(Permission p : permissionList){
            permissions.add(p.getPermission());
        }
        return permissions;
    }
}
