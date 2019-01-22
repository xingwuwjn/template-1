package com.template.mapper;

import com.template.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao
 */
public interface UserMapper {
    User loadUserByUsername(String username);

    User dbUser(@Param("username")String username, @Param("password")String password);


    int hrReg(@Param("username") String username, @Param("password") String password);

    List<User> getHrsByKeywords(@Param("keywords") String keywords);

    int updateHr(User user);

    int deleteRoleByHrId(Long hrId);

    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);

    User getHrById(Long hrId);

    int deleteHr(Long hrId);

    List<User> getAllHr(@Param("currentId") Long currentId);
}
