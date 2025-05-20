package com.bvtw.service.crontask;

import org.springframework.stereotype.Service;

@Service
public class CronTestService {
    public void executeSomeLogic(String taskId) {
        System.out.println("Đang thực thi logic cho Task ID: " + taskId);
    }
}
