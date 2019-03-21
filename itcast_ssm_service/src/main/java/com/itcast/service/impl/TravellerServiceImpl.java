package com.itcast.service.impl;

import com.itcast.dao.TravellerDao;
import com.itcast.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
@Service
public class TravellerServiceImpl implements TravellerService {
    private final TravellerDao travellerDao;

    @Autowired
    public TravellerServiceImpl(TravellerDao travellerDao) {
        this.travellerDao = travellerDao;
    }
}
