package com.terwergreen.plugins.setting;

import com.terwergreen.plugins.PluginInterface;
import com.terwergreen.plugins.setting.front.SettingApi;
import com.terwergreen.plugins.setting.front.SettingController;
import com.terwergreen.plugins.setting.service.impl.SettingServiceImpl;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展点
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/19 22:53:24
 **/
@Extension
public class SettingPluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(SettingPluginExtension.class);
    private GenericApplicationContext applicationContext;

    public SettingPluginExtension(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("SettingPluginExtension contructor");
        // 注册插件依赖
        registerBeans();
    }

    private void registerBeans() {
        applicationContext.registerBean(SettingController.class);
        logger.info("SettingPluginExtension registerBean " + SettingController.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(SettingApi.class);
        logger.info("SettingPluginExtension registerBean " + SettingApi.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(SettingServiceImpl.class);
        logger.info("SettingPluginExtension registerBean " + SettingServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "SettingPlugin identify in plugin";
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("setting", "Setting");
        return dataMap;
    }
}
