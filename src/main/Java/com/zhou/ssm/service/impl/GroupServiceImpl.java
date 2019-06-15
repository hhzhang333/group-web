package com.zhou.ssm.service.impl;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.dao.TblgroupMapper;
import com.zhou.ssm.model.Tblgroup;
import com.zhou.ssm.service.GroupService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Resource
    private TblgroupMapper groupDao;
    private Logger log = Logger.getLogger(GroupServiceImpl.class);

    public List<Tblgroup> getAll() {
        log.info("查看所有组会通知");
        return groupDao.selectAll();
    }

    public int insert(Tblgroup t){
        return groupDao.insert(t);
    }

    public int delete(int id){
        return groupDao.deleteByPrimaryKey(id);
    }

    public Tblgroup getGroup(int id){
        return groupDao.selectByPrimaryKey(id);
    }

}
