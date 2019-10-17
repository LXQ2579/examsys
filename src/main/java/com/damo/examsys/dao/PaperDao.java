package com.damo.examsys.dao;

import com.damo.examsys.entity.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/17  11:53:00
 */
@Repository
public interface PaperDao {

    List<Paper> findAll();

//    void add(Paper paper);



}
