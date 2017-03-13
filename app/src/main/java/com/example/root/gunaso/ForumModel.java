package com.example.root.gunaso;

/**
 * Created by root on 2/25/17.
 */

public class ForumModel {

    private String email;
    private String subject;
    private String body;
    private String name;

    public ForumModel(){

    }

    public ForumModel(String email, String subject, String body, String name) {
        this.email = email;
        this.subject = subject;
        this.body = body;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
