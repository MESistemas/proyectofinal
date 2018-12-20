/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.usuario.Usuario;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Matias
 */
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 20)
    @NotEmpty
    private String nombre;

    @Column(name = "apellido", length = 15)
    @NotEmpty
    private String apellido;

    @Column(name = "dni", length = 8, unique=true)
    @NotEmpty
    private String dni;

    @Column(name = "genero", length = 1)
    @NotEmpty
    private String genero;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date fecha_Nacimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }



    @ManyToOne
    @JoinColumn(name = "fk_alu_cur", referencedColumnName = "id")
    private Curso curso;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "alumno")
    private List<Nota> notas;

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void addNota(Nota notas) {
        this.notas.add(notas);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Nota> getNota() {
        return notas;
    }

    public void setNota(List<Nota> notas) {
        this.notas = notas;
    }

}
