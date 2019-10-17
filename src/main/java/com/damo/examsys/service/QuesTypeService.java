package com.damo.examsys.service;

import com.damo.examsys.entity.QuesType;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:37:00
 */
public interface QuesTypeService {

    List<QuesType> findAllPage(HashMap<String, Integer> pageMap);

    List<QuesType> findAll();

    QuesType findByName(String quesTypeName);

    QuesType findById(Integer quesTypeId);

    void update(QuesType quesType);

    void deleteById(Integer quesTypeId);

    void add(QuesType quesType);

}
