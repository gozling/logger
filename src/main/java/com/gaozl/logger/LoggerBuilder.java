package com.gaozl.logger;

/**
 * @author gaozl Create by 2017/11/28
 */
public interface LoggerBuilder {

    //运行时日志
    public Logger getLogger();

    //命令行日志
    public Logger getConLogger();
}
