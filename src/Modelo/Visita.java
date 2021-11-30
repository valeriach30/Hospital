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
public class Visita {
    
    // --------- ATRIBUTOS ---------
    
    private int numVisita;
    private Date fecha;
    private int codigoPaciente;
    private int codigoMedico;
    private String motivo;
    

    // --------- CONSTRUCTORES ---------
    
    public Visita() {
    }

    public Visita(int numVisita, Date fecha, int codigoPaciente, int codigoMedico, String motivo) {
        this.numVisita = numVisita;
        this.fecha = fecha;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.motivo = motivo;
    }

    // --------- GETS y SETS ---------

    public int getNumVisita() {
        return numVisita;
    }

    public void setNumVisita(int numVisita) {
        this.numVisita = numVisita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public int getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(int codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    @Override
    public String toString() {
        return "{Numero de Visita: "+ numVisita +","
               + "Fecha: "+ fecha +","
               + "Codigo del Paciente: "+ codigoPaciente +","
               + "Codigo del Medico: "+ codigoMedico +","
               + "Motivo: "+ motivo +"} \n";
    }

}
