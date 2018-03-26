package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.RoleMapper;
import com.daily.model.Role;
import com.daily.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class RoleService{

        @Autowired
        private RoleMapper mapper;

        public Integer save(Role role){
			return mapper.save(role);
        }
        
        public void update(Role role){
			mapper.update(role);
        }
        
        public void deleteById(Integer id){
			mapper.deleteById(id);
        }
        
        public int queryByCount(Role role){
			return mapper.queryByCount(role);
        }
		
        public List<Role> queryByList(Page page, Role role){
			String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
		    paramsMap.put("role", role.getRole());
		    paramsMap.put("description", role.getDescription());
		    paramsMap.put("pageQueryCondition", pageQueryCondition);
			return mapper.queryByList(paramsMap);
        }
		
        public List<Role> queryByRole(Role role){
			return mapper.queryByRole(role);
        }
		
        public Role queryById(Integer id){
			return mapper.queryById(id);
        }
}
