package com.mlefevre.scheduler.batch;

import com.mlefevre.scheduler.mail.Mailer;
import com.mlefevre.scheduler.mail.MailerFactory;
import com.mlefevre.scheduler.mail.impl.SpringMailer;
import com.mlefevre.scheduler.mail.model.Credentials;
import com.mlefevre.scheduler.mail.model.MailMessage;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Arrays;
import java.util.Date;

public class MailTasklet implements Tasklet {

    private Configuration configuration;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        MailMessage message = new MailMessage();
        message.setSender("matthieu.lefevre91@gmail.com");
        message.setSubject("Test message");
        message.setTo(Arrays.asList("lefevre.matthieu@outlook.com"));
        SimpleHash root = new SimpleHash(ObjectWrapper.SIMPLE_WRAPPER);
        root.put("date", new Date());
        message.setBody(FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("report.html"), root));


        Mailer mailer = MailerFactory.getMailer(SpringMailer.class);
        mailer.configure("smtp.gmail.com", 587, new Credentials("matthieu.lefevre91@gmail.com", "eQxOYaxz"));
        mailer.send(message);

        return RepeatStatus.FINISHED;
    }


    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
