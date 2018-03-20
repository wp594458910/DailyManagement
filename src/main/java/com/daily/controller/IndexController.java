package com.daily.controller;

import com.daily.model.Page;
import com.daily.model.Url;
import com.daily.service.UrlService;
import com.daily.util.ListUtils;
import com.daily.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private static final Integer MENU_TYPE = 1;
    private static final Integer URL_TYPE = 2;

    @RequestMapping("index.do")
    public String index(Url url, Page page, ModelMap model) {
        page.setMaxRows(8);
        url.setTypeid(URL_TYPE);
        List<Url> list = urlService.queryByUrl(url);
        page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
        page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
        List<Url> urlList = urlService.queryByList(page, url);
        List<Url> menuList = urlService.queryByType(MENU_TYPE);
        List<Url> normalList = ListUtils.getListByNum(urlService.queryByType(URL_TYPE), 4);
        model.put("menuList", menuList);
        model.put("urlList", urlList);
        model.put("normalList", normalList);
        model.put("page", page);
        model.put("url", url);
        return "front";
    }

    @RequestMapping("enterSite.do")
    @ResponseBody
    public void enterSite(Url url) {
        url = urlService.queryById(url.getId());
        url.setTimes(url.getTimes() + 1);
        urlService.update(url);
    }
}
