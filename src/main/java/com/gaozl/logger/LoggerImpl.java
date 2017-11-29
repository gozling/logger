package com.gaozl.logger;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaozl Create by 2017/11/28
 */
public class LoggerImpl implements Logger{

    private final LogWriter logWriter;
    private String module;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public LoggerImpl(String module, LogWriter logWriter) {
        this.module = module;
        this.logWriter = logWriter;
    }

    @Override
    public void debug(String msg) {
        log(msg, "DEBUG");
    }

    @Override
    public void info(String msg) {
        log(msg, "INFO");
    }

    @Override
    public void warn(String msg) {
        log(msg, "WARN");
    }

    @Override
    public void error(String msg) {
        log(msg, "ERROR");
    }

    @Override
    public void fatal(String msg) {
        log(msg, "FATAL");
    }

    private void log(String msg, String logLevel) {
        String logText = String.format("%s [%s] [%s] %s\r\n", sdf.format(new Date()), module, logLevel, msg);
        logWriter.log(logText);
    }

    @Override
    public void debug(String format, Object... args) {
        String logText = String.format(format, args);
        debug(logText);
    }

    @Override
    public void debug(String format, Throwable arg) {

    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void info(String format, Object... args) {
        String logText = MessageFormat.format(String.format(format, args), args);
        info(logText);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void warn(String format, Object... args) {
        String logText = MessageFormat.format(String.format(format, args), args);
        warn(logText);
    }

    @Override
    public void warn(String format, Throwable arg) {

    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void error(String format, Object... args) {
        String logText = MessageFormat.format(String.format(format, args), args);
        error(logText);
    }

    @Override
    public void error(String format, Throwable arg) {

    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void fatal(String format, Object... args) {
        String logText = MessageFormat.format(String.format(format, args), args);
        fatal(logText);
    }

    @Override
    public void fatal(String format, Throwable arg) {

    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }



}
