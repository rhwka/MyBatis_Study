package com.yang.mybatis.test;

import com.yang.mybatis.mapper.ParameterMapper;
import com.yang.mybatis.pojo.User;
import com.yang.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式：${}和￥{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种请款：
     * 1、mapper接口方法的参数为单个的字面量类型
     *可以通过${}和￥{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2、mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以arg0，arg1..为键，以参数为值
     * b>以param1，param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3、若mapper接口方法的参数有多个时，可以手动手动将这些参数放在一个map中存储
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4、mapper接口方法的参数是一个实体类类型的参数
     * 因此只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5、使用@param注解命名参数
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>@Param注解的值为键，以参数为值
     * b>以param1，param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    // 验证登录使用@Param
    @Test
    public void testcheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }



    // 验证登录（User）
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null,"lisi","123",23,"男","123@qq.com"));
        System.out.println(result);

    }


    // 验证登录（map）
    @Test
    public void testcheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }


    // 验证登录
    @Test
    public void testcheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
    }


    // 根据用户名查询用户
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
        System.out.println("你好啊Git!");
        System.out.println("你好git， hot-fix");
        System.out.println("你好啊git hot-fix");
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }


}
