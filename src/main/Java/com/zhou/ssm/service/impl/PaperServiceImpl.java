package com.zhou.ssm.service.impl;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.model.Tblpaper;
import com.zhou.ssm.dao.TblpaperMapper;
import com.zhou.ssm.service.PaperService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperServiceImpl  implements PaperService{
    @Resource
    private TblpaperMapper paperDao;
    private Logger log = Logger.getLogger(NewsServiceImpl.class);

    public List<Tblpaper> getAll() {
        return paperDao.selectAll();
    }

    public int insert(Tblpaper t){
        return paperDao.insert(t);
    }

    public int delete(int id){
        return paperDao.deleteByPrimaryKey(id);
    }

    public Tblpaper getPaper(int id){
        return paperDao.selectByPrimaryKey(id);
    }
}
