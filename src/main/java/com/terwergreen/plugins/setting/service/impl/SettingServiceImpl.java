package com.terwergreen.plugins.setting.service.impl;

import com.alibaba.fastjson.JSON;
import com.terwergreen.core.CommonService;
import com.terwergreen.plugins.setting.service.SettingService;
import com.terwergreen.pojo.SiteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务实现
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/19 22:53:24
 **/
@Service
public class SettingServiceImpl implements SettingService {
    private static final Logger logger = LoggerFactory.getLogger(SettingServiceImpl.class);

    @Autowired
    private CommonService commonService;

    @Override
    public String getSettingInfo() {
        SiteConfig siteConfig = commonService.getSiteConfig();
        if (null != siteConfig) {
        return JSON.toJSONString(siteConfig);
        }
        return "no data";
        }
    }
