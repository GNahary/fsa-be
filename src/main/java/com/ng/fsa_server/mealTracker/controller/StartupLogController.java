package com.ng.fsa_server.mealTracker.controller;


import com.ng.fsa_server.mealTracker.model.StartupLog;
import com.ng.fsa_server.mealTracker.service.StartupLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/documents")
public class StartupLogController {

    @Autowired
    private StartupLogService startupLogService;

    @GetMapping("/{pid}")
    public ResponseEntity<StartupLog> getDocumentByPid(@PathVariable int pid) {
        Optional<StartupLog> document = startupLogService.getDocumentByPid(pid);
        if (document.isPresent()) {
            return ResponseEntity.ok(document.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}