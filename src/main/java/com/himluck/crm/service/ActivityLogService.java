package com.himluck.crm.service;

import com.himluck.crm.model.ActivityLog;
import com.himluck.crm.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    public ActivityLog saveActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }
}
