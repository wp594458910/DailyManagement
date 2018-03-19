package com.daily.controller;

import com.daily.model.Url;
import com.daily.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Creator : peng
 * Date : 2018-03-19
 * Time : 14:35
 */
@Controller
public class IndexController {
    @Autowired
    private UrlService urlService;

    @RequestMapping("index.do")
    public String index(ModelMap model){
        Url url = new Url();
        url.setTypeid(1);
        List<Url> menuList = urlService.queryByUrl(url);
        url.setTypeid(2);
        List<Url> urlList = urlService.queryByUrl(url);
        model.put("menuList", menuList);
        model.put("urlList", urlList);
        return "front";
    }
}
