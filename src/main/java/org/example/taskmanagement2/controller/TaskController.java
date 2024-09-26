package org.example.taskmanagement2.controller;

import org.example.taskmanagement2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.taskmanagement2.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		if(taskService.getTaskById(id) != null) {
			return taskService.getTaskById(id);
		} else throw new RuntimeException("Task not found");
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
		//return "Hello World";

	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		if(taskService.getTaskById(id) != null) {
			return taskService.updateTask(id, task);
		}
		throw new RuntimeException("Task not found");
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTaskById(id);
	}

}

