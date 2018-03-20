package com.daily.service;

import com.daily.model.Page;
import com.daily.mapper.UrlMapper;
import com.daily.model.Url;
import com.daily.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created By FeastCoding.
 */
@Service
public class UrlService{

        @Autowired
        private UrlMapper mapper;

        public Integer save(Url url){
			return mapper.save(url);
        }
        
        public void update(Url url){
			mapper.update(url);
        }
        
        public void deleteById(Integer id){
			mapper.deleteById(id);
        }
        
        public int queryByCount(Url url){
			return mapper.queryByCount(url);
        }
		
        public List<Url> queryByList(Page page, Url url){
			String pageQueryCondition = " limit " + page.getStart() + " , " + page.getMaxRows();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
		    paramsMap.put("name", url.getName());
		    paramsMap.put("url", url.getUrl());
		    paramsMap.put("typeid", url.getTypeid());
		    paramsMap.put("pageQueryCondition", pageQueryCondition);
			return mapper.queryByList(paramsMap);
        }
		
        public List<Url> queryByUrl(Url url){
			return mapper.queryByUrl(url);
        }

        public List<Url> queryByType(Integer typeId){
            Url url = new Url();
            url.setTypeid(typeId);
            return mapper.queryByUrl(url);
        }
		
        public Url queryById(Integer id){
			return mapper.queryById(id);
        }
}
