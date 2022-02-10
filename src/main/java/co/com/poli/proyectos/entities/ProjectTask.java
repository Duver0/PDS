package co.com.poli.proyectos.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Getter
@Setter
@Entity

@Table(name = "projectTask")
public class ProjectTask extends EntityBase {

    @Column(name="name")
    @NotBlank(message = "Name may not be blank")
    private String name;

    @Column(name="summary")
    @NotEmpty(message = "No puede estar vacio")
    private String summary;

    @Column(name="acceptance_criteria")
    private String acceptanceCriteria;



    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="priority")
    @Size(min = 1, max = 5, message = "Debe ser entre 1 o 5 caracteres")
    private int priority;

    @Column(name="hours")
    @PositiveOrZero(message = "Debe ser un valor mayor a cero")
    @Size(min = 1, max = 8, message = "Debe ser entre 1 o 8 caracteres")
    private Double hours;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="project_identifier", updatable=false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
