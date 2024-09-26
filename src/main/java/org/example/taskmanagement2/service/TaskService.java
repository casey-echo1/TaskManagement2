package org.example.taskmanagement2.service;


import org.example.taskmanagement2.model.Task;
import org.example.taskmanagement2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		if (taskRepository.existsById(id)) {
			return taskRepository.findById(id).get();
		}
		else throw new RuntimeException("Task not found");
	}

	public Task createTask(Task updatedTask) {
		return taskRepository.save(updatedTask);
	}

	public Task updateTask(Long id, Task updatedTask) {
		updatedTask = getTaskById(id);
		updatedTask.setTitle(updatedTask.getTitle());
		updatedTask.setDescription(updatedTask.getDescription());
		updatedTask.setStatus(updatedTask.getStatus());
		return taskRepository.save(updatedTask);
	}

	public void deleteTaskById(Long id) {
		if (taskRepository.existsById(id)) {
			taskRepository.deleteById(id);
		}
	}


}
