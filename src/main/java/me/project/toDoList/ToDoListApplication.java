package me.project.toDoList;

import me.project.toDoList.model.entity.TaskEntity;
import me.project.toDoList.service.TaskService;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {



		SpringApplication.run(ToDoListApplication.class, args);


	}

}
