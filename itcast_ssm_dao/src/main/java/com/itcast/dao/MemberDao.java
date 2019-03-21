package com.itcast.dao;

import com.itcast.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface MemberDao {
    /**
     *
     * @param id
     * @return
     */
    @Select("select * from member where id = #{id}")
    Member findById(String id);
}
