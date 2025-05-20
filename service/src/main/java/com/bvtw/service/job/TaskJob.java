package com.bvtw.service.job;

import com.bvtw.service.crontask.CronTestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskJob implements Job {

    @Autowired
    private CronTestService cronTestService;

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getMergedJobDataMap();
        String id = dataMap.getString("id");

        log.info("TaskJob is running with id: {}", id);
        cronTestService.executeSomeLogic(id);
    }
}
