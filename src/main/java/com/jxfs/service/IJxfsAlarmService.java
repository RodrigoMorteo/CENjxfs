package com.jxfs.service;

import com.jxfs.events.JxfsException;

public interface IJxfsAlarmService extends IJxfsBaseService {
    
    // Method for triggering the alarm
    int alarm(boolean on, int controlID) throws JxfsException; 

    // Other methods inherited from IJxfsBaseService 
    // ...
}