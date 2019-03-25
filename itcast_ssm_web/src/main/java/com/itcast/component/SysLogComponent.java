package com.itcast.component;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.SysLog;
import com.itcast.exception.SysException;
import com.itcast.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019-03-21 14:38
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogComponent {
    private final SysLogService sysLogService;

    @Autowired
    public SysLogComponent(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", defaultValue = "5")
                                        Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List<SysLog> sysLogs = sysLogService.findAll(page,pageSize);
            PageInfo <SysLog> pageInfo = new PageInfo <SysLog>(sysLogs);
            mv.addObject("pageInfo", pageInfo);
            mv.setViewName("syslog-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询日志记录失败!");
        }
    }
}
