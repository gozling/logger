package com.gaozl.logger;

/**
 * @author gaozl Create by 2017/11/28
 */
public interface Logger {


    void info(String msg);

    void info(String format, Object... args);

    boolean isInfoEnabled();

    void debug(String msg);

    void debug(String format, Object... args);

    void debug(String format, Throwable arg);

    boolean isDebugEnabled();

    void warn(String msg);

    void warn(String format, Object... args);

    void warn(String format, Throwable arg);

    boolean isWarnEnabled();

    void error(String msg);

    void error(String format, Object... args);

    void error(String format, Throwable arg);

    boolean isErrorEnabled();

    void fatal(String msg);

    void fatal(String format, Object... args);

    void fatal(String format, Throwable arg);

    boolean isFatalEnabled();
}
