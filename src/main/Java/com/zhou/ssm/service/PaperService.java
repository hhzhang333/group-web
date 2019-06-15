package com.zhou.ssm.service;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.model.Tblpaper;

import java.util.List;

public interface PaperService {
    List<Tblpaper> getAll();
    int insert(Tblpaper t);
    int delete(int id);
    Tblpaper getPaper(int id);
}
