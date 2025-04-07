package com.jxfs.events;
import java.util.Date;

/**
* IJxfsErrorLogListener.java
*/
public interface IJxfsErrorLogListener
{
    public boolean initialize(String parameters);
    public void errorLogOccurred(String source_identification, 
        String origin,
        long errorCode,
        long extendedErrorCode,
        String message,
        String hintText,
        String help_url,
        String curr_thread,Date timestamp);
    public void shutdown();
    public String getDescription();
}