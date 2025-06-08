package me.project.toDoList.service;

import lombok.RequiredArgsConstructor;
import me.project.toDoList.model.entity.StatusEnum;
import me.project.toDoList.model.entity.TaskEntity;
import me.project.toDoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;


    public TaskEntity createTask(TaskEntity task) {

        return repository.save(task);

    }

    public TaskEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public List<TaskEntity> findAll() {
        return repository.findAll();
    }

    public void deleteTask(Long id) {
        TaskEntity task = findById(id);
        repository.delete(task);
    }

    public TaskEntity updateTask(Long id, TaskEntity updatedTask) {
        TaskEntity task = findById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        return repository.save(task);
    }

    public TaskEntity updateStatus(Long id, StatusEnum status) {
        TaskEntity task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setStatus(status);
        return repository.save(task);
    }

    public List<TaskEntity> findByStatus(StatusEnum status) {
        List<TaskEntity> allTask = findAll();

        return allTask.stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }
}
