/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.models.entitys.profesor;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "profesores")
public class Profesor implements Serializable {

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

    @Column(name = "dni", length = 8)
    @NotEmpty
    private String dni;

    @Column(name = "genero", length = 1)
    @NotEmpty
    private String genero;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotEmpty
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
    
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profesor")
    private List<Materia> materias;

    public void addMateria(Materia materias) {
        this.materias.add(materias);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profesor")
    private List<Usuario> usuarios;

    private void addUsuario(Usuario usuarios) {
        this.usuarios.add(usuarios);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

