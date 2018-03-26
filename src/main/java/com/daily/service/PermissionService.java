package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.PermissionMapper;
import com.daily.model.Permission;
import com.daily.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper mapper;

    public Integer save(Permission permission) {
        return mapper.save(permission);
    }

    public void update(Permission permission) {
        mapper.update(permission);
    }

    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    public int queryByCount(Permission permission) {
        return mapper.queryByCount(permission);
    }

    public List<Permission> queryByList(Page page, Permission permission) {
        String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("name", permission.getName());
        paramsMap.put("type", permission.getType());
        paramsMap.put("url", permission.getUrl());
        paramsMap.put("permission", permission.getPermission());
        paramsMap.put("pageQueryCondition", pageQueryCondition);
        return mapper.queryByList(paramsMap);
    }

    public List<Permission> queryByPermission(Permission permission) {
        return mapper.queryByPermission(permission);
    }

    public Permission queryById(Integer id) {
        return mapper.queryById(id);
    }
}
