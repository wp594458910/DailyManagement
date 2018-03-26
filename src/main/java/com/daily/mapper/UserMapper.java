package com.daily.mapper;

import java.util.*;

import com.daily.model.Permission;
import com.daily.model.Role;
import com.daily.model.User;

/**
 * Created By FeastCoding.
 */
public interface UserMapper{
    Integer save(User model);

    void update(User model);

    void deleteById(Integer id);

    int queryByCount(User model);

    List<User> queryByList(Map paramsMap);
	
	List<User> queryByUser(User model);

    User queryById(Integer id);

    User findByUsername(String username);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);
}