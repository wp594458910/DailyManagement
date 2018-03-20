package com.daily.controller;


import java.util.List;

import com.daily.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daily.model.Url;
import com.daily.model.Page;
import com.daily.service.UrlService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping("queryUrlBypage.do")
    public String queryUrlBypage(Url url, Page page, ModelMap model) {
        page.setMaxRows(5);
        List<Url> list = urlService.queryByUrl(url);
        page.setStart(PageUtils.getPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
        page.setTotalPage(PageUtils.getTotalPage(page.getPageNumber(), page.getTotalPage(), list.size(), page.getMaxRows()));
        List<Url> urlList = urlService.queryByList(page, url);
        model.put("page", page);
        model.put("urlList", urlList);
        model.put("url", url);
        return "/url_list";
    }

    @RequestMapping("addUrl.do")
    public String addUrl(Url url, HttpServletRequest request) {
        url.setTimes(0);
        urlService.save(url);
        return "redirect:/queryUrlBypage.do";
    }


    @RequestMapping("editUrl.do")
    public String editUrl(Url url, ModelMap model) {
        url = urlService.queryById(url.getId());
        model.put("url", url);
        return "/url_edit";
    }

    @RequestMapping("updateUrl.do")
    public String updateUrl(Url url, HttpServletRequest request) {
        urlService.update(url);
        return "redirect:/queryUrlBypage.do";
    }

    @RequestMapping("deleteUrlByid.do")
    public String deleteUrlByid(Url url) {
        urlService.deleteById(url.getId());
        return "redirect:/queryUrlBypage.do";
    }
}
