package com.daily.mapper;

import java.util.*;
import com.daily.model.UserRole;

/**
 * Created By FeastCoding.
 */
public interface UserRoleMapper{
    public Integer save(UserRole model);

    public void update(UserRole model);

    public void deleteById(Integer id);

    public int queryByCount(UserRole model);

    public List<UserRole> queryByList(Map paramsMap);
	
	public List<UserRole> queryByUserRole(UserRole model);

    public UserRole queryById(Integer id);
}