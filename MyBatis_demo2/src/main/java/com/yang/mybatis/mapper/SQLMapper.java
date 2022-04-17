package com.yang.mybatis.mapper;

import com.yang.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 杨
 * @Date 2022/3/5 17:59
 * @Version 1.0
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
