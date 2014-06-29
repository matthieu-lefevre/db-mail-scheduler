package com.mlefevre.scheduler.mail;

import com.mlefevre.scheduler.mail.impl.AbstractMailer;

public class MailerFactory {

    public static <T extends AbstractMailer> Mailer getMailer(Class<T> mailerImplClass) {
        try {
            return (Mailer) mailerImplClass.newInstance();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
