package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name="project")
public class Project extends EntityBase{

    @Id
    @Column(name="id",unique=true)
    @NotBlank(message = "El campo no puede estar vacio")
    private Long id;

    @Column(name="project_identifier",unique=true, updatable=false)
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(min = 5, max = 7, message = "Debe ser entre 5 y 7 caracteres")
    private String ProjectIdentifier;

    @Column(name="description")
    @NotBlank(message = "El campo no puede estar vacio")
    private String description;

    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project",cascade = CascadeType.ALL)
    @JoinColumn(name="backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}