package com.daily.mapper;

import java.util.*;
import com.daily.model.RolePermission;

/**
 * Created By FeastCoding.
 */
public interface RolePermissionMapper{
    public Integer save(RolePermission model);

    public void update(RolePermission model);

    public void deleteById(Integer id);

    public int queryByCount(RolePermission model);

    public List<RolePermission> queryByList(Map paramsMap);
	
	public List<RolePermission> queryByRolePermission(RolePermission model);

    public RolePermission queryById(Integer id);
}