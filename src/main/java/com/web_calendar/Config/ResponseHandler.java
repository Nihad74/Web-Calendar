package com.web_calendar.Config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseHandler {

    private String message;
    private String event;

    private String date;


    public ResponseHandler() {
    }

    public ResponseHandler(String message,String event, String date) {
        this.message = message;
        this.event = event;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public String getEvent() {
        return event;
    }
}
