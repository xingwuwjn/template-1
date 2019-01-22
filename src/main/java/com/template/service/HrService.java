package com.template.service;

import com.template.bean.User;
import com.template.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class HrService {

    @Autowired
    UserMapper userMapper;

    public User loadUserByUsername(String username){
        return userMapper.loadUserByUsername(username);
    }

    public User dbUser(String username, String password){
        return userMapper.dbUser(username,password);
    }

    public int hrReg(String username,String password){
        return userMapper.hrReg(username,password);
    }

    public List<User> getHrsByKeywords(String keywords) {
        return userMapper.getHrsByKeywords(keywords);
    }

    public int updateHr(User user) {
        return userMapper.updateHr(user);
    }

    public int updateHrRoles(Long hrId, Long[] rids) {
        try{
            int i = userMapper.deleteRoleByHrId(hrId);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return userMapper.addRolesForHr(hrId, rids);
    }

    public User getHrById(Long hrId) {
        return userMapper.getHrById(hrId);
    }

    public int deleteHr(Long hrId) {
        return userMapper.deleteHr(hrId);
    }



    public List<User> getAllHr() {
        return userMapper.getAllHr(null);
    }
}
