package com.example.springbatch.controller;

import com.example.springbatch.entity.Recovery;
import com.example.springbatch.service.RecoveryService;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recoveries")
@AllArgsConstructor
public class JobController {

    private final RecoveryService recoveryService;

    @PostMapping("import")
    public void importCsvToDBJob() {
        recoveryService.importScvFile();
    }

    @GetMapping
    public List<Recovery> findAllRecoveries() {
        return recoveryService.getAllRecoveries();
    }

    @GetMapping("/{id}")
    public Recovery findAllRecoveries(@PathVariable Long id) {
        return recoveryService.getRecoveryById(id);
    }

}
