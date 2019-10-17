package com.damo.examsys.service.impl;

import com.damo.examsys.dao.PaperDao;
import com.damo.examsys.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/17  11:58:00
 */
public class PaperServiceImpl implements PaperDao {

    @Autowired
    private PaperDao paperDao;

    @Override
    public List<Paper> findAll() {
        return paperDao.findAll();
    }

}
