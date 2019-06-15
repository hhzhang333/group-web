package com.zhou.ssm.service;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.model.Tblgroup;
import java.util.List;

public interface GroupService {
    List<Tblgroup> getAll();
    int insert(Tblgroup t);
    int delete(int id);
    Tblgroup getGroup(int id);
}
