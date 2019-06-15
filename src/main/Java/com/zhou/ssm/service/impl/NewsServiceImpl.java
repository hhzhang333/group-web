package com.zhou.ssm.service.impl;

import com.zhou.ssm.model.Tblnews;
import com.zhou.ssm.dao.TblnewsMapper;
import com.zhou.ssm.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Resource
    private TblnewsMapper newsDao;

    public List<Tblnews> getAll() {
        return newsDao.selectAll();
    }

    public Tblnews getNews(int id) {
        return newsDao.selectByPrimaryKey(id);
    }

    public int insert(Tblnews t){
        return newsDao.insert(t);
    }

    public int delete(int id){
        return newsDao.deleteByPrimaryKey(id);
    }
}
