package com.gaozl.logger;//package com.wechat.util;
//
//
//import org.slf4j.Logger;
//
///**
// * @author gaozl Create by 2017/11/27
// */
//public class Log {
//  public final static String EXCEPTION = "EXCEPTION ";
//  public final static String IGNORED = "IGNORED ";
//
//  private final static Logger logger = Log.getLogger();
//
//
//  public static Logger getLogger() {
//    return org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2]
//        .getClassName());
//  }
//
//
//  public static void main(String[] args) {
//
//      AppContext.context.installLogback();
//      logger.info("test logback info", "","");
//      logger.debug("test logback debug");
//      logger.error("test logback error");
//  }
//}
