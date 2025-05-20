package com.bvtw.service.crontask;

import com.bvtw.domain.dto.crontask.CreateTaskRequest;
import com.bvtw.domain.entity.Task;
import com.bvtw.repositories.ITaskRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final ITaskRepository taskRepository;

    private final JobService jobService;

    @PostConstruct
    public void initScheduledTasks() {
        log.info("Initializing scheduled tasks from database...");

        taskRepository.findAll().forEach(task -> {
            try {
                jobService.scheduleTaskJob(task);
                log.info("Scheduled task {} ({})", task.getName(), task.getId());
            } catch (SchedulerException e) {
                log.error("Failed to reschedule task {}: {}", task.getId(), e.getMessage());
            }
        });
    }


    /**
     * Create a task
     *
     * @param request CreateTaskRequest
     * @return Task
     */
    @Transactional
    public Task create(CreateTaskRequest request) {
        Task task = taskRepository.save(Task.builder()
                .name(request.getName())
                .taskGroup(request.getGroup())
                .cronExpression(request.getCronExpression())
                .build());

        try {
            jobService.scheduleTaskJob(task);
        } catch (SchedulerException e) {
            log.error("Error scheduling task: {}", task.getName(), e);
        }

        return task;
    }

    @Transactional
    public void delete(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        boolean isUnScheduledJob = jobService.unScheduleTaskJob(task);
        if (isUnScheduledJob) {
            taskRepository.delete(task);
            log.info("Task {} deleted successfully", task.getName());
        } else {
            log.error("Error deleting task: {}", task.getName());
        }
    }

    @Transactional
    public void delete(String id) {
        delete(UUID.fromString(id));
    }
}
