package com.bvtw.domain.dto.crontask;

import com.bvtw.domain.entity.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskResponse {
    private String id;

    private String name;

    private String group;

    private String cronExpression;

    /**
     * Convert to TaskResponse
     *
     * @param task Task
     * @return TaskResponse
     */
    public static TaskResponse convert(Task task) {
        return TaskResponse.builder()
                .id(task.getId().toString())
                .name(task.getName())
                .group(task.getTaskGroup())
                .cronExpression(task.getCronExpression())
                .build();
    }
}
