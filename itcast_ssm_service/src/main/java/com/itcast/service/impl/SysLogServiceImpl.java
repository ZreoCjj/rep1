package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.SysLogDao;
import com.itcast.domain.SysLog;
import com.itcast.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019-03-21 14:36
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;


    @Override
    public List<SysLog> findAll(Integer page , Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
