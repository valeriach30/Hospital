/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vchin
 */
public class Paciente {

    // --------- ATRIBUTOS ---------
    
    private int CodigodelPaciente;
    private int cedula;
    private String nombre; 
    private String sexo; 
    private Date fechaNacimiento; 
    private String direccion;
    private String provincia; 
    private int telefono;
    private ArrayList<HistorialMedico> HistorialMedicoPaciente = new ArrayList();
    
    // --------- CONSTRUCTORES ---------
    
    public Paciente() {
        
    }

    public Paciente(int CodigodelPaciente, int cedula, String nombre, String sexo, 
                    Date fechaNacimiento, String direccion, String provincia, 
                    int telefono) {
        
        this.CodigodelPaciente = CodigodelPaciente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    // --------- GETS y SETS ---------
    
    public int getCodigodelPaciente() {
        return CodigodelPaciente;
    }

    public void setCodigodelPaciente(int CodigodelPaciente) {
        this.CodigodelPaciente = CodigodelPaciente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<HistorialMedico> getHistorialMedicoPaciente() {
        return HistorialMedicoPaciente;
    }

    public void setHistorialMedicoPaciente(ArrayList<HistorialMedico> HistorialMedicoPaciente) {
        this.HistorialMedicoPaciente = HistorialMedicoPaciente;
    }
    
    @Override
    public String toString() {
        return "{Codigo Paciente: "+CodigodelPaciente +","
               + "Cedula: "+cedula +","
               + "Nombre: "+nombre +","
               + "Sexo: "+sexo +","
               + "Fecha de Nacimiento: "+ fechaNacimiento +","
               + "Direccion: "+direccion +","
               + "Provincia: "+ provincia +","
               + "Telefono: "+ telefono +"} \n";
    }
    
    
}
