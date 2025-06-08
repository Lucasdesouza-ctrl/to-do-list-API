package me.project.toDoList.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TaskResponseDTO {

    private long id;
    private String title;
    private String description;
    private Timestamp createdAt;

}
