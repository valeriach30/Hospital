/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author vchin
 */
public class HistorialMedico {
    
    // ------------------ ATRIBUTOS ------------------
    
    private float peso;
    private int presion;
    private String enfermedad;
    
    // ------------------ CONSTRUCTORES ------------------
    
    public HistorialMedico(){
    }

    public HistorialMedico(float peso, int presion, String enfermedad) {
        this.peso = peso;
        this.presion = presion;
        this.enfermedad = enfermedad;
    }
    
    // ------------------ GETS y SETS ------------------
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    @Override
    public String toString() {
        return "{ Peso: "+ peso +", "
                + "Presion: " + presion + ", "
               + "Enfermedad: "+ enfermedad +"} \n";
    }
}
