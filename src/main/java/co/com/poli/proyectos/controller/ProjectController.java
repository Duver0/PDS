package co.com.poli.proyectos.controller;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import co.com.poli.proyectos.helper.ResponseBuilder;
import co.com.poli.proyectos.model.Response;
import co.com.poli.proyectos.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService service;
    private final ResponseBuilder builder;

    @Autowired
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
    public Response create(@RequestBody @Valid Project project, BindingResult result) {

        if (result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        service.create(project);
        return builder.success(project);
    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}