package com.gaozl.logger;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author gaozl Create by 2017/11/28
 */
public class LoggerFactory implements LoggerBuilder {

    private LoggerFactory() {
    }

    private static class SingletonHolder {
        private static final LoggerFactory instance = new LoggerFactory();
    }

    public static final LoggerFactory instance() {
        return SingletonHolder.instance;
    }

    private static final ThreadLocal<Map<String, Logger>> loggers = new ThreadLocal<Map<String, Logger>>() {
        @Override
        public Map<String, Logger> initialValue() {
            return Maps.newConcurrentMap();
        }
    };


    @Override
    public Logger getLogger() {

        try {
            Class<?> clazz = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            return getLogger(clazz, LogType.RUNTIME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Logger getConLogger() {

        try {
            Class<?> clazz = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            return getLogger(clazz, LogType.CONSOLE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Logger getLogger(Class<?> T, LogType logType) {
        String tagName = T.getName() + "@" + logType;
        Logger logger = loggers.get().get(tagName);
        if (logger == null) {
            logger = new LoggerImpl(T.getName(), new LogWriterImpl(logType));
            loggers.get().put(tagName, logger);
        }
        return logger;
    }

}
