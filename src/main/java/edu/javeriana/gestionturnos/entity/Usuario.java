package edu.javeriana.gestionturnos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El username es obligatorio.")
    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Column(nullable = false, length = 255)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_id", unique = true)
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    @NotNull(message = "El rol es obligatorio.")
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id, String username, String password, Docente docente, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.docente = docente;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Docente getDocente() {
        return docente;
    }

    public Rol getRol() {
        return rol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}