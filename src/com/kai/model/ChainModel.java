package com.kai.model;

/**
 * Created by FengKai on 2018/6/26.
 */
public class ChainModel {
    /**
     * 责任链模式
     * 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
     */
    public static void main(String[] args) {
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        infoLogger.logMessage(AbstractLogger.ERROR, "top info");
    }
}

abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextAbstractLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextAbstractLogger = logger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextAbstractLogger != null) {
            nextAbstractLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO MESSAGE:" + message);
    }
}

class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }


    @Override
    protected void write(String message) {
        System.out.println("ERROR MESSAGE" + message);
    }
}

class DebugLogger extends AbstractLogger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG MESSAGE:" + message);
    }
}