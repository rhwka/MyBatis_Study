package com.yang.mybatis.mapper;

import com.yang.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 杨
 * @Date 2022/3/8 9:12
 * @Version 1.0
 */
public interface CacheMapper {

    /**
     *
     */
    Emp getEmpByEid(@Param("eid") Integer eid);


    /**
     *
     */
    void insertEmp(Emp emp);
}
