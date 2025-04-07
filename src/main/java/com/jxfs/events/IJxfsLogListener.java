package com.jxfs.events;
import java.util.Date;

/**
* IJxfsLogListener.java
*/
public interface IJxfsLogListener extends IJxfsErrorLogListener
{
    public void logOccurred(String source_identification,
        String origin,
        int level,
        String log_message,
        String curr_thread,
        Date timestamp);
} 