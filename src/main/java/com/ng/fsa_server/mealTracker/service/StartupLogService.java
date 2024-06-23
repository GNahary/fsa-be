package com.ng.fsa_server.mealTracker.service;

import com.ng.fsa_server.mealTracker.dao.StartupLogRepository;
import com.ng.fsa_server.mealTracker.model.StartupLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StartupLogService {

    @Autowired
    private StartupLogRepository startupLogRepository;

    public Optional<StartupLog> getDocumentByPid(int pid) {
        return startupLogRepository.findByPid(pid);
    }
}