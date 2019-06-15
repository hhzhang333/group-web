package com.zhou.ssm.service;

import com.zhou.ssm.model.Tblnews;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface NewsService {
    List<Tblnews> getAll();
    int insert(Tblnews t);
    int delete(int id);
    Tblnews getNews(int id);
}
