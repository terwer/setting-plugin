package com.terwergreen.plugins.setting.front;

import com.terwergreen.plugins.setting.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author Terwer
 * @version 1.0
 * 2018/11/29 1:23
 **/
@Controller
@RequestMapping("setting")
public class SettingController {
    @Autowired
    private SettingService settingService;

    @RequestMapping(produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String setting() {
        return settingService.getSettingInfo();
    }
}
