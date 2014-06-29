package com.mlefevre.scheduler.mail.exception;

public class MailerException extends Exception {

    public MailerException(String message) {
        super(message);
    }

    public MailerException(Throwable cause) {
        super(cause);
    }

}
