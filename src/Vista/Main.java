/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Hospital;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Visita;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author vchin
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        
        boolean menu = true;
        Hospital hospital = new Hospital();
        hospital.Prueba();
        while(menu){
            
            // ----- MENU -----
            JOptionPane ventPrincipal = new JOptionPane();
            String op = ventPrincipal.showInputDialog("Bienvenido al sistema del hospital, que desea hacer? \n"
                   + "1 = Insertar un paciente\n"
                   + "2 = Insertar un medico\n"
                   + "3 = Insertar una visita\n"
                   + "4 = Eliminar un paciente\n"
                   + "5 = Eliminar un medico\n"
                   + "6 = Eliminar una visita\n"
                   + "7 = Eliminar todos los pacientes\n"
                   + "8 = Eliminar todos los medicos\n"
                   + "9 = Eliminar todos las visitas\n"
                   + "10 = Modificar un paciente\n"
                   + "11 = Modificar un medico\n"
                   + "12 = Modificar una visita\n"
                   + "13 = Reporte Pacientes\n"
                   + "14 = Reporte Medicos\n"
                   + "15 = Reporte Visitas\n"
                   + "16 = Historial Medico por paciente\n"
                   + "17 = Salir");
            
            int opcion = Integer.parseInt(op);
            
            // ----- EJECUTAR OPCION -----
            switch(opcion){
                
                // --- INSERTAR PACIENTE ---
                case 1:
                    if(hospital.insertarPaciente() == true){
                        JOptionPane.showMessageDialog(null,"Paciente Agregaddo", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Paciente No Agregaddo", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                    
                // --- INSERTAR MEDICO ---
                case 2:
                    if(hospital.insertarMedico() == true){
                        JOptionPane.showMessageDialog(null,"Medico Agregaddo", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Medico No Agregaddo", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                    
                // --- INSERTAR VISITA ---
                case 3:
                    if(hospital.insertarVisita() == true){
                        JOptionPane.showMessageDialog(null,"Visita Agregaddo", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Visita No Agregaddo", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                
                // --- ELIMINAR PACIENTE ---
                case 4:
                    if(hospital.eliminarPaciente() == true){
                        JOptionPane.showMessageDialog(null,"Paciente Eliminado", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Paciente No Eliminado", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                    
                // --- ELIMINAR MEDICO ---
                case 5:
                    if(hospital.eliminarMedico() == true){
                        JOptionPane.showMessageDialog(null,"Medico Eliminado", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Medico No Eliminado", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                
                // --- ELIMINAR VISITA ---
                case 6:
                    if(hospital.eliminarVisita() == true){
                        JOptionPane.showMessageDialog(null,"Visita Eliminada", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Visita No Eliminada", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                
                // --- ELIMINAR TODOS LOS PACIENTES ---
                case 7:
                    hospital.eliminarAllPacientes();
                    JOptionPane.showMessageDialog(null,"Pacientes eliminados", "Exito",
                    JOptionPane.INFORMATION_MESSAGE); 
                    break;
                
                // --- ELIMINAR TODOS LOS MEDICOS ---
                case 8:
                    hospital.eliminarAllMedicos();
                    JOptionPane.showMessageDialog(null,"Medicos eliminados", "Exito",
                    JOptionPane.INFORMATION_MESSAGE); 
                    break;
                
                // --- ELIMINAR TODOS LAS VISITAS ---
                case 9:
                    hospital.eliminarAllVisitas();
                    JOptionPane.showMessageDialog(null,"Visitas eliminadas", "Exito",
                    JOptionPane.INFORMATION_MESSAGE); 
                    break;
                
                // --- MODIFICAR PACIENTE ---
                case 10:
                    if(hospital.modificarPaciente() == true){
                        JOptionPane.showMessageDialog(null,"Paciente Modificado", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Paciente no Modificado", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                
                // --- MODIFICAR MEDICO ---
                case 11:
                    if(hospital.modificarMedico() == true){
                        JOptionPane.showMessageDialog(null,"Medico Modificado", "Exito",
                        JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Medico no Modificado", "Error",
                        JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                
                // --- MODIFICAR VISITA ---
                case 12:
                    
                    break;
                    
                // --- REPORTE PACIENTES ---
                case 13:
                    String pacientes = hospital.reportPacientes();
                    if(pacientes != ""){
                        JOptionPane.showMessageDialog(null,pacientes, "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No hay pacientes registrados", "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                
                // --- REPORTE MEDICOS ---
                case 14:
                    String medicos = hospital.reportMedicos();
                    if(medicos != ""){
                        JOptionPane.showMessageDialog(null,medicos, "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No hay medicos registrados", "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                
                // --- REPORTE VISITAS ---
                case 15:
                    String visitas = hospital.reportVisita();
                    if(visitas != ""){
                        JOptionPane.showMessageDialog(null,visitas, "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Este medico no tiene visitas", "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                    
                // --- HISTORIAL MEDICO DE PACIENTE
                case 16:
                    String historial = hospital.reportHistorial();
                    if(historial != ""){
                        JOptionPane.showMessageDialog(null,historial, "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Este paciente no tiene historial", "Reporte",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 17:
                    menu = false;
                    break;
            }
        }
    }
}
// eso est doo por hoy
