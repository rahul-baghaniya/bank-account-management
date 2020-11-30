package com.cybrilla.bankaccountmanagement.util;

/*
* Singleton class use case
* */
public class Logging {
    private static Logging logging;

    private Logging(){};

    public static Logging getLoggingInstance(){
        if(logging==null){
            logging = new Logging();
        }
        return logging;
    }

    public void log(LogLevel logLevel, String msg){
        System.out.println(logLevel + ": " + msg);
    }
}
