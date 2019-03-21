package com.itcast.service;

import com.itcast.domain.SysLog;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019-03-21 14:32
 */
public interface SysLogService {
    /**
     * 查询所有记录
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<SysLog> findAll(Integer page , Integer pageSize) throws Exception;

    /**
     * 保存记录
     * @param sysLog
     */
    void save(SysLog sysLog);
}
