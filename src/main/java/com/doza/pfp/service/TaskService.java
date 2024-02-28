package com.doza.pfp.service;

import com.doza.pfp.dao.ProjectDAO;
import com.doza.pfp.dao.TaskDAO;
import com.doza.pfp.dto.TaskDTO;

import java.util.List;
import java.util.stream.Collectors;


public class TaskService {

    private static final TaskService INSTANCE = new TaskService();
    private final ProjectDAO projectDAO = ProjectDAO.getInstance();
    private final TaskDAO taskDAO = TaskDAO.getInstance();

    private TaskService() {
    }

    public List<TaskDTO> findAllByProjectId(Long projectId) {
        return taskDAO.findAllByTaskId(projectId).stream()
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getName()
                ))
                .collect(Collectors.toList());
    }

    public static TaskService getInstance() {
        return INSTANCE;
    }
}
