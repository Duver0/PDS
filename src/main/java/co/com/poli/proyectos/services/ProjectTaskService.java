package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.ProjectTask;

import java.util.List;

public interface ProjectTaskService {
    List<ProjectTask> findAll();
    ProjectTask create(ProjectTask projectTask);
}
