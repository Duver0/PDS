package co.com.poli.proyectos.controller;

import co.com.poli.proyectos.entities.Backlog;

import co.com.poli.proyectos.services.BacklogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/backlog")
public class BacklogController {
    @Autowired
    private BacklogService service;
    @GetMapping
    public List<Backlog> findAll(){
        return service.findAll();
    }
    @PostMapping
    public Backlog create(@Valid @RequestBody Backlog backlog){
        return service.create(backlog);
    }
}
