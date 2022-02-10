package co.com.poli.proyectos.controller;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import co.com.poli.proyectos.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService service;
    @GetMapping
    public List<Project> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<ProjectTask> findByIdeTasks(@Valid @PathVariable String id){
        return service.findByIdeTasks(id);
    }
    @GetMapping("/hours/{id}")
    public double totaldeHoras(@Valid @PathVariable String id){
        return service.totaldeHoras(id);
    }
    @GetMapping("/hours/{id}/{estado}")
    public double totaldeHorasEstado(@Valid @PathVariable String id,@PathVariable String estado){
        return service.totaldeHorasEstado(id,estado);
    }
    @DeleteMapping("/{idtask}/{id}")
    public ProjectTask deleteTask(@Valid @PathVariable Long idtask,@PathVariable String id){
        return service.deleteTask(idtask,id);
    }

    //findByIdTasks
    @PostMapping
    public Project create(@RequestBody Project project){
        return service.create(project);
    }
}
