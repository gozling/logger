package com.gaozl.logger;


import java.io.*;
import java.text.MessageFormat;

/**
 * @author gaozl Create by 2017/11/28
 */
public class LogWriterImpl implements LogWriter {

    private Writer logWriter;

    public LogWriterImpl(LogType logType) {
        try {
            switch (logType) {
                case RUNTIME:
                    String userdir = System.getProperty("user.dir");
                    File logPath = new File(MessageFormat.format("{0}/logs/{1}.log", userdir, "runtime"));
                    if(!logPath.getParentFile().exists()) {
                        logPath.getParentFile().mkdirs();
                    }
                    if(!logPath.exists()) {
                        logPath.createNewFile();
                    }

                    logWriter = new OutputStreamWriter(new FileOutputStream(logPath, true));
                    break;
                case CONSOLE:
                    logWriter = new OutputStreamWriter(System.out);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void log(String log) {
        try {
            logWriter.write(log);
            System.out.println(log);
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
