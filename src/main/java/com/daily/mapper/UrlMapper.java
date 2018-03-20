package com.daily.mapper;

import java.util.*;

import com.daily.model.Url;

/**
 * Created By FeastCoding.
 */
public interface UrlMapper {
    public Integer save(Url model);

    public void update(Url model);

    public void deleteById(Integer id);

    public int queryByCount(Url model);

    public List<Url> queryByList(Map paramsMap);

    public List<Url> queryByUrl(Url model);

    public Url queryById(Integer id);
}