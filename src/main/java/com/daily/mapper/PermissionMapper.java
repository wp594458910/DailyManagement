package com.daily.mapper;

import java.util.*;
import com.daily.model.Permission;

/**
 * Created By FeastCoding.
 */
public interface PermissionMapper{
    public Integer save(Permission model);

    public void update(Permission model);

    public void deleteById(Integer id);

    public int queryByCount(Permission model);

    public List<Permission> queryByList(Map paramsMap);
	
	public List<Permission> queryByPermission(Permission model);

    public Permission queryById(Integer id);
}