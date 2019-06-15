package com.zhou.ssm.service.impl;

/**
 * Created by Administrator on 2017/4/23.
 */
import com.zhou.ssm.model.Tblroom;
import com.zhou.ssm.dao.TblroomMapper;
import com.zhou.ssm.service.RoomService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl  implements RoomService{
    @Resource
    private TblroomMapper roomDao;
    private Logger log = Logger.getLogger(NewsServiceImpl.class);

    public List<Tblroom> getAll(int i) {
        log.info("查看相对会议室租借记录");
        return roomDao.selectAll(i);
    }

    public List<Tblroom> getRoom(String id) {
        log.info("查看此管理员会议租借记录");
        return roomDao.selectRoom(id);
    }

    public List<Tblroom> getDate(Date date,int i) {
        log.info("查看当天会议租借记录");
        return roomDao.selectDate(date,i);
    }

    public int insert(Tblroom t){
        return roomDao.insert(t);
    }

    public int delete(int id){
        return roomDao.deleteByPrimaryKey(id);
    }

}
