package com.daily.mapper;

import java.util.*;
import com.daily.model.Role;

/**
 * Created By FeastCoding.
 */
public interface RoleMapper{
    public Integer save(Role model);

    public void update(Role model);

    public void deleteById(Integer id);

    public int queryByCount(Role model);

    public List<Role> queryByList(Map paramsMap);
	
	public List<Role> queryByRole(Role model);

    public Role queryById(Integer id);
}