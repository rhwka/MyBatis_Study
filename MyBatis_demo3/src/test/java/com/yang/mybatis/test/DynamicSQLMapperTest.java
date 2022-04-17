package com.yang.mybatis.test;

import com.yang.mybatis.mapper.DynamicSQLMapper;
import com.yang.mybatis.pojo.Emp;
import com.yang.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨
 * @Date 2022/3/6 17:32
 * @Version 1.0
 */
public class DynamicSQLMapperTest {

    /**
     * 动态SQL：
     * 1、if：根据标签中test属性所对应的表达式决定标签中内容是否需要拼接到SQL中
     * 2、where：当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或 or 去掉
     * 当where标签中没有内容时，此时where标签没有任何效果
     * 注意：where标签不能将其中内容后面多余的and 或 or去掉
     * 3、trim：
     * 若标签中有内容时：
     * prefix|suffix：将trim标签中内容前面或后面添加指定内容
     * prefixOverrides|suffixOverrides：将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时，trim标签也没有任何效果
     * 4、choose,when,otherwise,相当于if...else if...else
     * when至少要有一个，otherwise最多只能有一个
     * 5、foreach
     * collection：设置需要循环的数组或集合
     * item：表示数组或集合中的每一个数据
     * separator：循环体之间的分隔符
     * open：foreach标签所循环的所有内容的开始符号
     * close：foreach标签所循环的所有内容的结束符号
     * 6、sql标签
     * 设置SQL片段<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用SQL片段<include refid="empColumns"></include>
     */

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));
    }


    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{9,10,11});
        System.out.println(result);
    }



    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", null, "男", "123@qq.com"));
        System.out.println(list);
    }


    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "", ""));
        System.out.println(list);

    }
}
