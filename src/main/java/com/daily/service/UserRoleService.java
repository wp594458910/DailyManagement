package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.UserRoleMapper;
import com.daily.model.UserRole;
import com.daily.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class UserRoleService{

        @Autowired
        private UserRoleMapper mapper;

        public Integer save(UserRole userRole){
			return mapper.save(userRole);
        }
        
        public void update(UserRole userRole){
			mapper.update(userRole);
        }
        
        public void deleteById(Integer id){
			mapper.deleteById(id);
        }
        
        public int queryByCount(UserRole userRole){
			return mapper.queryByCount(userRole);
        }
		
        public List<UserRole> queryByList(Page page, UserRole userRole){
			String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
		    paramsMap.put("userid", userRole.getUserid());
		    paramsMap.put("pageQueryCondition", pageQueryCondition);
			return mapper.queryByList(paramsMap);
        }
		
        public List<UserRole> queryByUserRole(UserRole userRole){
			return mapper.queryByUserRole(userRole);
        }
		
        public UserRole queryById(Integer id){
			return mapper.queryById(id);
        }
}
