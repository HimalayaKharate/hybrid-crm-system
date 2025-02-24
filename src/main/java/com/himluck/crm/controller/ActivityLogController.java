package com.himluck.crm.controller;

import com.himluck.crm.model.ActivityLog;
import com.himluck.crm.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm-api/v1/activity-logs")
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogService.getAllActivityLogs();
    }

    @PostMapping
    public ActivityLog createActivityLog(@RequestBody ActivityLog activityLog) {
        return activityLogService.saveActivityLog(activityLog);
    }
}

