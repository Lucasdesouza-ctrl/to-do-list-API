package me.project.toDoList.controller;


import lombok.RequiredArgsConstructor;
import me.project.toDoList.dto.TaskMapper;
import me.project.toDoList.dto.TaskRequestDTO;
import me.project.toDoList.dto.TaskResponseDTO;
import me.project.toDoList.model.entity.StatusEnum;
import me.project.toDoList.model.entity.TaskEntity;
import me.project.toDoList.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;
    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO dto) {
        TaskEntity entity = taskMapper.toEntity(dto);
        TaskEntity created = service.createTask(entity);
        return ResponseEntity.ok(taskMapper.toDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAll() {
        List<TaskEntity> entities = service.findAll();
        List<TaskResponseDTO> dtos = entities.stream()
                .map(taskMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{status}")
    public  ResponseEntity<List<TaskResponseDTO>> findByStatus (@PathVariable StatusEnum status ){
        List<TaskEntity> entities = service.findByStatus((status));
         List<TaskResponseDTO> dto = entities.stream()
                .map(taskMapper::toDTO)
                .toList();
         return ResponseEntity.ok(dto);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
        TaskEntity task = service.findById(id);
        return ResponseEntity.ok(taskMapper.toDTO(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        TaskEntity updated = service.updateTask(id, taskMapper.toEntity(dto));
        return ResponseEntity.ok(taskMapper.toDTO(updated));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> updateStatus(@PathVariable Long id, @RequestParam StatusEnum status) {
        TaskEntity updated = service.updateStatus(id, status);
        return ResponseEntity.ok(taskMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
