package com.doza.pfp.service;

import com.doza.pfp.dao.ProjectDAO;
import com.doza.pfp.dto.ProjectDTO;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class ProjectService {

    private static final ProjectService INSTANCE = new ProjectService();
    private final ProjectDAO projectDAO = ProjectDAO.getInstance();

    public List<ProjectDTO> findAll() {
        return projectDAO.findAll().stream()
                .map(project -> new ProjectDTO(
                        project.getId(),
                        project.getName()
                ))
                .collect(toList());
    }

    public static ProjectService getInstance() {
        return INSTANCE;
    }
}
