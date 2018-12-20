/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.profesor.Profesor;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matias
 */
@Entity
@Table(name = "materias")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_materia", length = 25)
    @NotEmpty
    private String nombre_Materia;

    @Column(name = "hr_inicio")
    @NotNull
    private LocalTime hr_inicio;

    @Column(name = "hr_fin")
    @NotNull
    private LocalTime hr_fin;

    public LocalTime getHr_inicio() {
        return hr_inicio;
    }

    public void setHr_inicio(LocalTime hr_inicio) {
        this.hr_inicio = hr_inicio;
    }

    public LocalTime getHr_fin() {
        return hr_fin;
    }

    public void setHr_fin(LocalTime hr_fin) {
        this.hr_fin = hr_fin;
    }

    
    
    

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materia")
    private List<Agenda> calendarios;

    private void addCalendario(Agenda calendarios) {
        this.calendarios.add(calendarios);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materia")
    private List<Nota> notas;

 
    private void addNota(Nota notas) {
        this.notas.add(notas);
    }

    public String getNombre_Materia() {
        return nombre_Materia;
    }

    public void setNombre_Materia(String nombre_Materia) {
        this.nombre_Materia = nombre_Materia;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @ManyToOne
    @JoinColumn(name = "fk_mat_pro", referencedColumnName = "id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "fk_mat_cur", referencedColumnName = "id")
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Agenda> getCalendarios() {
        return calendarios;
    }

    public void setCalendarios(List<Agenda> calendarios) {
        this.calendarios = calendarios;
    }

    @Override
    public String toString() {
        return nombre_Materia;
    }

}
