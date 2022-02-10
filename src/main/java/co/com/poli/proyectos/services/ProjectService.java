package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project create(Project project);
    /*List<Project> findByIdTasks(Long id) ;*/
    List<ProjectTask> findByIdeTasks(String id);
    double totaldeHoras(String id);
    double totaldeHorasEstado (String id,String estado);
    ProjectTask deleteTask(Long idtask,String id);
}
