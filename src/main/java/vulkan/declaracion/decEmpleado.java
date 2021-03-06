/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gabri
 */
@Entity
@Table (name="Empleado")
public class decEmpleado {
    @Column
    private String nombre;
    @Column
    private int telefono;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private String email;
    @Column
    private int desactivado;
    @Column
    private int id_tipo_documento;
    @Column
    private String numIdentidad_empleado;
    @Column
    private String nombre_documento;
    @Column
    private String empleadoNombre_puesto;
    
    @Id
    private int id_empleado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDesactivado() {
        return desactivado;
    }

    public void setDesactivado(int desactivado) {
        this.desactivado = desactivado;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNumIdentida_empleado() {
        return numIdentidad_empleado;
    }

    public void setNumIdentida_empleado(String numIdentida_empleado) {
        this.numIdentidad_empleado = numIdentida_empleado;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getEmpleadoNombre_puesto() {
        return empleadoNombre_puesto;
    }

    public void setEmpleadoNombre_puesto(String empleadoNombre_puesto) {
        this.empleadoNombre_puesto = empleadoNombre_puesto;
    }
    
}
