package com.example.peter.exercise.Models;

import java.io.Serializable;

/**
 * Created by Peter on 13.09.2018.
 */

public class Message implements Serializable {
    private String message;
    private String subject;
    private String mail;

    public Message(){}

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
