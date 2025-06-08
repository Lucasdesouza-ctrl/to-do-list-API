package me.project.toDoList.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasklist")
public class TaskEntity {

    @Id
    private long id;

    private String title;
    private String description;
    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PENDING;

}
