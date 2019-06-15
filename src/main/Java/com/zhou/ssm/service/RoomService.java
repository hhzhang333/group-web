package com.zhou.ssm.service;

/**
 * Created by Administrator on 2017/4/23.
 */
import com.zhou.ssm.model.Tblroom;
import java.util.List;
import java.util.Date;

public interface RoomService {
    List<Tblroom> getAll(int i);
    List<Tblroom> getRoom(String id);//根据会议室选择
    List<Tblroom> getDate(Date date,int i);//根据日期和会议室选择
    int insert(Tblroom r);
    int delete(int id);
}