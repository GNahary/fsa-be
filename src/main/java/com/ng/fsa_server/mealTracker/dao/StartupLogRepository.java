package com.ng.fsa_server.mealTracker.dao;

import com.ng.fsa_server.mealTracker.model.StartupLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StartupLogRepository extends MongoRepository<StartupLog, String> {
    Optional<StartupLog> findByPid(int pid);
}
