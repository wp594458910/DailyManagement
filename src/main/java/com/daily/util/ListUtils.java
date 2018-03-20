package com.daily.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Creator : peng
 * Date : 2018-03-20
 * Time : 15:41
 */
public class ListUtils {
    public static List getListByNum(List l, Integer num) {
        List list = new ArrayList();
        if (l.size() < num) {
            list = l;
        } else {
            for (int i = 0; i < num; i++) {
                list.add(l.get(i));
            }
        }
        return list;
    }
}
