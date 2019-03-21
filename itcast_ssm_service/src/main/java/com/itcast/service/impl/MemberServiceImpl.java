package com.itcast.service.impl;

import com.itcast.dao.MemberDao;
import com.itcast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
