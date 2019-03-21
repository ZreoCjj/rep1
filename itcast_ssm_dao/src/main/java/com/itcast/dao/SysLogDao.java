package com.itcast.dao;


import com.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019-03-21 14:44
 */
public interface SysLogDao {
    /**
     * 添加日志
     * @param sysLog
     */
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) " +
            "values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    /**
     * 查询所有记录
     * @return
     */
    @Select("select * from syslog")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="visitTime",property="visitTime"),
            @Result(column="ip",property="ip"),
            @Result(column="url",property="url"),
            @Result(column="executionTime",property="executionTime"),
            @Result(column="method",property="method"),
            @Result(column="username",property="username")
    })
    List<SysLog> findAll();
}
