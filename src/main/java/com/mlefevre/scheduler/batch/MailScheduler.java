package com.mlefevre.scheduler.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

public class MailScheduler {

    private Job job;

    private JobLauncher jobLauncher;


    public void run() {
        JobParameters parameters = new JobParametersBuilder()
                .addLong("currentTime", new Long(System.currentTimeMillis()))
                .toJobParameters();
        try {
            this.jobLauncher.run(this.job, parameters);

        } catch (JobExecutionAlreadyRunningException e) {
        } catch (JobRestartException e) {
        } catch (JobInstanceAlreadyCompleteException e) {
        } catch (JobParametersInvalidException e) {
        }
    }


    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }
}
