package com.example.springbatch.service;

import com.example.springbatch.entity.Recovery;
import com.example.springbatch.repository.RecoveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecoveryService {

    private final RecoveryRepository repository;
    private final JobLauncher jobLauncher;
    private final Job job;

    public List<Recovery> getAllRecoveries() {
        return repository.findAll();
    }

    public Recovery getRecoveryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found entity [" + id + "]"));
    }

    public void importScvFile() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
