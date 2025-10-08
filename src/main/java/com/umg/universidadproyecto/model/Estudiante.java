package com.umg.universidadproyecto.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "carne", unique = true, nullable = false, length = 20)
    private String carne;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "pin", nullable = false, length = 10)
    private String pin;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    @ManyToMany
    @JoinTable(
        name = "estudiante_curso",
        joinColumns = @JoinColumn(name = "estudiante_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<>();
    
    // Constructores
    public Estudiante() {
    }
    
    public Estudiante(String carne, String nombre, String pin, String correo) {
        this.carne = carne;
        this.nombre = nombre;
        this.pin = pin;
        this.correo = correo;
    }
    
    // Getters y Setters COMPLETOS
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCarne() {
        return carne;
    }
    
    public void setCarne(String carne) {
        this.carne = carne;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPin() {
        return pin;
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", carne=" + carne + ", nombre=" + nombre + '}';
    }
}