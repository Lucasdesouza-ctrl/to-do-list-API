package me.project.toDoList.dto;

import me.project.toDoList.model.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity toEntity (TaskRequestDTO dto){
        TaskEntity task = new TaskEntity();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCreatedAt(dto.getCreatedAt());

        return task;
    }

    public TaskResponseDTO toDTO(TaskEntity task){
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setId(task.getId());
        dto.setCreatedAt(task.getCreatedAt());

        return dto;
    }

}
