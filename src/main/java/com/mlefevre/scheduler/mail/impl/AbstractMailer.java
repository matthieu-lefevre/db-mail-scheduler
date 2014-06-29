package com.mlefevre.scheduler.mail.impl;

import com.mlefevre.scheduler.mail.Mailer;
import com.mlefevre.scheduler.mail.model.Credentials;

public abstract class AbstractMailer implements Mailer {

    protected static final int MAX_RECIPIENTS = 10;

    protected String host;
    protected int port = 587;
    protected Credentials credentials;


    public void configure(String host) {
        this.host = host;
    }

    public void configure(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void configure(String host, int port, Credentials credentials) {
        this.host = host;
        this.port = port;
        this.credentials = credentials;
    }

}
