package co.com.poli.proyectos.controller;


import co.com.poli.proyectos.entities.ProjectTask;

import co.com.poli.proyectos.services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/task")
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService service;
    @GetMapping
    public List<ProjectTask> findAll(){
        return service.findAll();
    }
    @PostMapping
    public ProjectTask create(@Valid @RequestBody ProjectTask projectTask){
        return service.create(projectTask);
    }
}
