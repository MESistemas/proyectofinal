package com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nota")
    private int nota;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fecha;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    @JoinColumn(name = "fk_not_alu", referencedColumnName = "id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "fk_not_mat", referencedColumnName = "id")
    private Materia materia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


}
