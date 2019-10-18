package com.damo.examsys.service.impl;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.dao.UserDao;
import com.damo.examsys.entity.Role;
import com.damo.examsys.entity.User;
import com.damo.examsys.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Override
    public Map<String,Object> findAllUser(int pageNum, int pageSize,Integer isDeleted) {
        PageHelper.startPage(pageNum,pageSize);
        Page<User> allUser = userDao.findAllUser(isDeleted);
        if (allUser.get(0) == null){
            throw new RuntimeException("数据查询异常");
        }
        PageInfo<User> userPageInfo = new PageInfo<>(allUser);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code",0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", userPageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", userPageInfo.getList());
        return tableData;
    }

    @Override
    public JsonBean<String> updateUserById(HashMap<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uname",map.get("uname"));
        hashMap.put("userInfoname",map.get("userInfo.name"));
        hashMap.put("userInfosex",map.get("userInfo.sex"));
        hashMap.put("userInfouserinfoid",map.get("userInfo.userinfoid"));
        Integer integer = userDao.updateUserInfo(hashMap);
        String o = (String)map.get("uid");
        Integer uid = Integer.valueOf(o);
        List<Map<String, Integer>> list=new ArrayList<>();
        for (Map.Entry<String, Object> entity : map.entrySet()) {
            if(entity.getKey().indexOf("roleList[")>-1){
                Map<String, Integer> roleMap = new HashMap<>();
                roleMap.put("uid",Integer.valueOf(map.get("uid").toString()));
                roleMap.put("rid",Integer.valueOf(entity.getValue().toString()));
                list.add(roleMap);
            }
        }
        Integer deleteUserRole = roleDao.deleteUserRoleByUserId(uid);
        Integer updateUserRole = roleDao.updateUserRole(list);

        if (integer>0 && deleteUserRole>0 && updateUserRole >0){
            return new JsonBean<>(0,"更新成功");
        }
        return new JsonBean<>(1,"更新失败");
    }

    @Override
    public JsonBean<String> deleteUserById(Integer uid , Integer isDeleted) {
        if (uid == null){
            return new JsonBean<String>(1,"参数错误");
        }
        Integer integer = userDao.deleteUserById(uid ,isDeleted);
        if (integer<1 ){
            throw new RuntimeException("删除错误，请检查");
        }
        return new JsonBean<>(0,"删除成功");
    }

    @Override
    public JsonBean deleteUserByIds(String [] uid,Integer isDeleted) {
        if (uid.length<1){
            throw new RuntimeException("请选择数据");
        }
        Integer integer = userDao.deleteUserByIds(uid,isDeleted);
        if (integer<1){
            throw new RuntimeException("批量删除错误，请检查");
        }
        return new JsonBean<>(0,"批量删除成功");
    }


}
