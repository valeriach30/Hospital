/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author vchin
 */
public class Medico {
    
    // --------- ATRIBUTOS ---------
    
    private int codigoMedico;
    private int cedula;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private String direccion;
    private float salario;
    private int telefono;
    
    
    // --------- CONSTRUCTORES ---------

    public Medico() {
    }

    public Medico(int codigoMedico, int cedula, String nombre, String apellidos,
                  String especialidad, String direccion, float salario, 
                  int telefono) {
        this.codigoMedico = codigoMedico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.salario = salario;
        this.telefono = telefono;
    }
    
    // --------- GETS y SETS ---------

    public int getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(int codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "{Codigo Medico: "+codigoMedico +","
               + "Cedula: "+cedula +","
               + "Nombre: "+nombre +","
               + "Apellidos: "+apellidos +","
               + "Especialidad: "+ especialidad +","
               + "Direccion: "+direccion +","
               + "Salario: "+ salario +","
               + "Telefono: "+ telefono +"} \n";
    }
    
}
