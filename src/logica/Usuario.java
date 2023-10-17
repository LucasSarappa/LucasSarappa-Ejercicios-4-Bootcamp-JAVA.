package logica;

import java.util.Objects;

public class Usuario {
    private String dni ;
    private String nombre ;
    private String apellido ;
    private String fecha_nacimiento ;
    private String profesion ;
    private String contacto;


    public Usuario(String dni, String nombre, String apellido,  String fecha_nacimiento, String profesion, String contacto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

        this.fecha_nacimiento = fecha_nacimiento;
        this.profesion = profesion;
        this.contacto = contacto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return dni.equals(usuario.dni);
    }

    // Método hashCode para calcular el hash basado en el DNI
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
