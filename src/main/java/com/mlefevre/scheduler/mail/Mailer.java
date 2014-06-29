package com.mlefevre.scheduler.mail;

import com.mlefevre.scheduler.mail.exception.MailerException;
import com.mlefevre.scheduler.mail.model.Credentials;
import com.mlefevre.scheduler.mail.model.MailMessage;

/**
 *
 */
public interface Mailer {

    void configure(String host);

    void configure(String host, int port);

    void configure(String host, int port, Credentials credentials);

    void send(MailMessage message) throws MailerException;

}
