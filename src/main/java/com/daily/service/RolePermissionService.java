package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.RolePermissionMapper;
import com.daily.model.RolePermission;
import com.daily.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class RolePermissionService{

        @Autowired
        private RolePermissionMapper mapper;

        public Integer save(RolePermission rolePermission){
			return mapper.save(rolePermission);
        }
        
        public void update(RolePermission rolePermission){
			mapper.update(rolePermission);
        }
        
        public void deleteById(Integer id){
			mapper.deleteById(id);
        }
        
        public int queryByCount(RolePermission rolePermission){
			return mapper.queryByCount(rolePermission);
        }
		
        public List<RolePermission> queryByList(Page page, RolePermission rolePermission){
			String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
		    paramsMap.put("roleid", rolePermission.getRoleid());
		    paramsMap.put("pageQueryCondition", pageQueryCondition);
			return mapper.queryByList(paramsMap);
        }
		
        public List<RolePermission> queryByRolePermission(RolePermission rolePermission){
			return mapper.queryByRolePermission(rolePermission);
        }
		
        public RolePermission queryById(Integer id){
			return mapper.queryById(id);
        }
}
