package com.adp.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NTActorStartUpListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        NTActorSystemUtil.startActorSystem();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        NTActorSystemUtil.stopActorSystem();
    }
}
