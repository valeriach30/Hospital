/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Visita;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vchin
 */
public class Hospital {
    
    // -----------------------------------------------ATRIBUTOS -----------------------------------------------
    ArrayList<Paciente> pacientes;
    ArrayList<Medico> medicos;
    ArrayList<Visita> visitas;
    
    // ----------------------------------------------- CONSTRUCTOR -----------------------------------------------
   
    public Hospital() {
        pacientes = new ArrayList();
        medicos = new ArrayList();
        visitas = new ArrayList();
    }
    
    
    // ----------------------------------------------- METODOS PRINCIPALES -----------------------------------------------
    
    // ------------------ INSERCIONES ------------------
    
    // -> INSERTAR PACIENTE <-
    public boolean insertarPaciente() throws ParseException{
        
        // --- Atributos
        String nombre, sexo, direccion, provincia;
        int cedula, telefono, codigoPaciente;
        
        // --- Conseguir Informacion -- 
        nombre = JOptionPane.showInputDialog("Escriba el nombre del paciente: ");
        
        try{
            cedula = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cedula del paciente: "));
        
            sexo = JOptionPane.showInputDialog("Escriba el sexo del paciente. Digite F si es mujer o M si es hombre: ");

            Date fechaNacimiento = new SimpleDateFormat("yyyy/mm/dd").parse(JOptionPane.showInputDialog("Escriba la fecha de nacimiento. "
            + "El formato debe ser AAAA/MM/DD"));

            direccion = JOptionPane.showInputDialog("Escriba la direccion del paciente: ");

            provincia = JOptionPane.showInputDialog("Escriba la provincia del paciente: ");
            
            try{
                telefono = Integer.parseInt(JOptionPane.showInputDialog("Escriba el telefono del paciente: "));

                codigoPaciente = pacientes.size()+1;

                // --- Agregar Paciente ---
                Paciente p = new Paciente(codigoPaciente, cedula, nombre, sexo, fechaNacimiento, direccion, provincia, telefono);
                pacientes.add(p);
                return true;
            }
            catch(Exception NumberFormatException){
                JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> INSERTAR MEDICO <-
    public boolean insertarMedico() {
        
        // --- Atributos
        String nombre, apellidos, direccion, especialidad;
        int cedula, telefono, codigoMedico;
        float salario;
        
        // --- Conseguir Informacion --
        try{
            nombre = JOptionPane.showInputDialog("Escriba el nombre del medico: ");
            apellidos = JOptionPane.showInputDialog("Escriba los apellidos del medico: ");
            especialidad = JOptionPane.showInputDialog("Escriba la especialidad del medico: ");
            direccion = JOptionPane.showInputDialog("Escriba la direccion del medico: ");
            cedula = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cedula del medico: "));
            telefono = Integer.parseInt(JOptionPane.showInputDialog("Escriba el telefono del medico: "));
            codigoMedico = medicos.size()+1;
            salario = Float.parseFloat(JOptionPane.showInputDialog("Escriba el salario del medico: "));

            // --- Agregar Medico ---
            Medico m = new Medico(codigoMedico, cedula, nombre, apellidos, especialidad, direccion, salario, telefono);
            medicos.add(m);
            return true;
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "El tipo de dato ingresado no es correcto debe ser entero o float (si es salario)", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> INSERTAR VISITA <-
    public boolean insertarVisita() throws ParseException {
        
        // --- Atributos ---
        int numVisita, codigoPaciente, codigoMedico, presion;
        Date fecha;
        String motivo, enfermedad;
        float peso;
        
        // --- Conseguir Informacion --
        try{
            codigoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del paciente: "));

            // Determinar si existe el codigo de paciente
            boolean respuesta = existePaciente(codigoPaciente);
            if(respuesta==true){

                codigoMedico = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del medico: "));
                // Determinar si existe el codido del medico
                boolean respuesta2 = existeMedico(codigoMedico);

                if(respuesta2==true){
                    // Conseguir el resto de informacion
                    motivo = JOptionPane.showInputDialog("Escriba el motivo de la visita: ");

                    fecha = new SimpleDateFormat("yyyy/mm/dd").parse(JOptionPane.showInputDialog("Escriba la fecha de la visita. "
                    + "El formato debe ser AAAA/MM/DD"));

                    numVisita = visitas.size();

                    // --- Agregar Visita ---
                    Visita v = new Visita(numVisita, fecha, codigoPaciente, codigoMedico, motivo);
                    visitas.add(v);

                    // --- Agregar un historial medico al paciente ---
                    HistorialMedico HM = new HistorialMedico();

                    enfermedad = JOptionPane.showInputDialog("Escriba la enfermedad del paciente (si tiene): ");
                    HM.setEnfermedad(enfermedad);

                    peso = Float.parseFloat(JOptionPane.showInputDialog("Escriba el peso del paciente: "));
                    HM.setPeso(peso);

                    presion = Integer.parseInt(JOptionPane.showInputDialog("Escriba la presion del paciente: "));
                    HM.setPresion(presion);

                    // Obtener el objeto paciente
                    Paciente pac = getPaciente(codigoPaciente);

                    // Obtener el array
                    ArrayList<HistorialMedico> HistorialArray =  pac.getHistorialMedicoPaciente();

                    // Agregar el historial al paciente
                    HistorialArray.add(HM);

                    // Update Array
                    pac.setHistorialMedicoPaciente(HistorialArray);

                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"El medico no existe, vuelva a intentarlo.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"El paciente no existe, vuelva a intentarlo.", "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // ------------------ ELIMINACIONES ------------------
    
    // -> ELIMINAR PACIENTE <-
    public boolean eliminarPaciente(){
        
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del paciente: "));

            // Determinar si el pacientte existe
            int existeP = determinarIndexP(codigo);

            // Existe
            if (existeP != -1){
                // Eliminar el paciente
                pacientes.remove(existeP);
                return true;
            }

            // No existe
            else{
                JOptionPane.showMessageDialog(null,"Paciente no existe", "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> ELIMINAR MEDICO <-
    public boolean eliminarMedico(){
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del medico: "));

            // Determinar si el medico existe
            int existeM = determinarIndexM(codigo);

            // Existe
            if (existeM != -1){
                // Eliminar el medico
                medicos.remove(existeM);
                return true;
            }

            // No existe
            else{
                JOptionPane.showMessageDialog(null,"Medico no existe", "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> ELIMINAR VISITA <-
    public boolean eliminarVisita(){
        try{
            int numVisita = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de la visita: "));
            // Determinar si el medico existe
            int existeV = determinarIndexV(numVisita);

            // Existe
            if (existeV != -1){
                visitas.remove(existeV);
                return true;
            }

            // No existe
            else{
                JOptionPane.showMessageDialog(null,"Visita no existe", "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> ELIMINAR TODOS LOS PACIENTES <-
    public void eliminarAllPacientes(){
        pacientes.clear();
    }
    
    // -> ELIMINAR TODOS LOS MEDICOS <-
    public void eliminarAllMedicos(){
        medicos.clear();
    }
    
    // -> ELIMINAR TODOS LAS VISITAS <-
    public void eliminarAllVisitas(){
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del medico: "));

            // Determinar si el medico existe
            int existeM = determinarIndexM(codigo);
            Medico medico = medicos.get(existeM);

            // Existe
            if (existeM != -1){
                // Obtener el array visitas del medico
                visitas.clear();
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ------------------ MODIFICACIONES ------------------
    
    // -> MODIFICAR PACIENTE <-
    public boolean modificarPaciente() throws ParseException{
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del paciente: "));
        
        // Determinar si el pacientte existe
        int existeP = determinarIndexP(codigo);
        
        // Existe
        if (existeP != -1){
            String op = JOptionPane.showInputDialog("Escoga lo que desea editar:\n"
                    + "1 = Cedula\n"
                    + "2 = Nombre\n"
                    + "3 = Sexo\n"
                    + "4 = Fecha de Nacimiento\n"
                    + "5 = Direccion\n"
                    + "6 = Provincia\n"
                    + "7 = Telefono\n");
            int opcion = Integer.parseInt(op);
            switch(opcion){
                case 1:
                    try{
                        pacientes.get(existeP).setCedula(Integer.parseInt(JOptionPane.showInputDialog("Escriba la nueva cedula: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 2:
                    pacientes.get(existeP).setNombre(JOptionPane.showInputDialog("Escriba el nuevo nombre: "));
                    return true;
                case 3:
                    pacientes.get(existeP).setSexo(JOptionPane.showInputDialog("Escriba el nuevo sexo (F o M): "));
                    return true;
                case 4:
                    try{
                        Date nuevaF = new SimpleDateFormat("yyyy/mm/dd").parse(JOptionPane.showInputDialog("Escriba la nueva fecha de nacimiento. "
                        + "El formato debe ser AAAA/MM/DD"));
                        pacientes.get(existeP).setFechaNacimiento(nuevaF);
                        return true;
                    }catch(Exception ParseException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha con el formato indicado", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 5:
                     pacientes.get(existeP).setDireccion(JOptionPane.showInputDialog("Escriba la nueva direccion: "));
                    return true;
                case 6:
                    pacientes.get(existeP).setProvincia(JOptionPane.showInputDialog("Escriba la nueva provincia: "));
                    return true;
                case 7:
                    try{
                        pacientes.get(existeP).setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo telefono: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
            }
            return false;
        }
        // No existe
        else{
            JOptionPane.showMessageDialog(null,"Paciente no existe", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> MODIFICAR MEDICO <-
    public boolean modificarMedico() throws ParseException{
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del medico: "));
        
        // Determinar si el medico existe
        int existeM = determinarIndexM(codigo);
        
        // Existe
        if (existeM != -1){
            
            String op = JOptionPane.showInputDialog("Escoga lo que desea editar:\n"
                    + "1 = Cedula\n"
                    + "2 = Nombre\n"
                    + "3 = Apellidos\n"
                    + "4 = Especialidad\n"
                    + "5 = Direccion\n"
                    + "6 = Salario\n"
                    + "7 = Telefono\n");
            int opcion = Integer.parseInt(op);
            switch(opcion){
                case 1:
                    try{
                        medicos.get(existeM).setCedula(Integer.parseInt(JOptionPane.showInputDialog("Escriba la nueva cedula: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 2:
                    medicos.get(existeM).setNombre(JOptionPane.showInputDialog("Escriba el nuevo nombre: "));
                    return true;
                case 3:
                    medicos.get(existeM).setApellidos(JOptionPane.showInputDialog("Escriba los nuevos apellidos: "));
                    return true;
                case 4:
                    medicos.get(existeM).setEspecialidad(JOptionPane.showInputDialog("Escriba la nueva especialidad: "));
                    return true;
                case 5:
                    medicos.get(existeM).setDireccion(JOptionPane.showInputDialog("Escriba la nueva direccion: "));
                    return true;
                case 6:
                    try{
                        medicos.get(existeM).setSalario(Float.parseFloat(JOptionPane.showInputDialog("Escriba el salario del medico: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un float", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 7:
                    try{
                        medicos.get(existeM).setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo telefono: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
            }
            return false;
        }
        
        // No existe
        else{
            JOptionPane.showMessageDialog(null,"Medico no existe", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // -> MODIFICAR VISITA <-
    public boolean modificarVisita() throws ParseException{

        int numVisita = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de la visita: "));
        
        int existeV = determinarIndexV(numVisita);
        
        // Existe
        if (existeV != -1){
            String op = JOptionPane.showInputDialog("Escoga lo que desea editar:\n"
                + "1 = Fecha\n"
                + "2 = Codigo del Medico\n"
                + "3 = Codigo del Paciente\n"
                + "4 = Motivo\n");

            int opcion = Integer.parseInt(op);
            switch(opcion){
                case 1:
                    try{
                        Date fecha = new SimpleDateFormat("yyyy/mm/dd").parse(JOptionPane.showInputDialog("Escriba la fecha de la visita. "
                            + "El formato debe ser AAAA/MM/DD"));
                        visitas.get(existeV).setFecha(fecha);
                        return true;
                    }catch(Exception ParseException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha con el formato indicado", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 2:
                    try{
                        visitas.get(existeV).setCodigoPaciente(Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo codigo del paciente: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 3:
                    try{
                        visitas.get(existeV).setCodigoMedico(Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo codigo del medico: ")));
                        return true;
                    }
                    catch(Exception NumberFormatException){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
                    }
                case 4:
                    visitas.get(existeV).setMotivo(JOptionPane.showInputDialog("Escriba el nuevo motivo de la visita: "));
                    return true;
            }
            return false;

        }
        else{
            JOptionPane.showMessageDialog(null,"Visita no existe", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    // ------------------ REPORTES ------------------
    
    // -> REPORTE PACIENTES <-
    public String reportPacientes(){
        String resultado = "";
        for (int i = 0; i < pacientes.size(); i++) {
            resultado += pacientes.get(i).toString();
        }
        return resultado;
    }
    
    // -> REPORTE MEDICOS <-
    public String reportMedicos(){
        String resultado = "";
        for (int i = 0; i < medicos.size(); i++) {
            resultado += medicos.get(i).toString();
        }
        return resultado;
    }
    
    // -> REPORTE VISITA <-
    public String reportVisita(){
        String resultado = "";
        for (int i = 0; i < visitas.size(); i++) {
            resultado += visitas.get(i).toString();
        }
        return resultado;
    }
    
    public String reportHistorial(){
        String resultado = "";
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Escriba el codigo del paciente: "));

            // Determinar si el pacientte existe
            int existeP = determinarIndexP(codigo);

            // Existe
            if (existeP != -1){

                // Obtener el array de historial medico
                resultado += "{ " + pacientes.get(existeP).getNombre() + ", " + 
                             pacientes.get(existeP).getCedula() + "\nHistorial Medico: \n";
                ArrayList<HistorialMedico> HM = pacientes.get(existeP).getHistorialMedicoPaciente();
                for (int i = 0; i < HM.size(); i++) {
                    resultado += HM.get(i).toString();
                }

                // Agregar visitas
                resultado += "Visitas: \n";
                for (int i = 0; i < visitas.size(); i++) {
                    if(visitas.get(i).getCodigoPaciente() == codigo){
                        resultado += visitas.get(i).toString();
                    }                
                }
                resultado += "}";
                return resultado;
            }

            // No existe
            else{
                JOptionPane.showMessageDialog(null,"Paciente no existe", "Error",
                JOptionPane.ERROR_MESSAGE);
                return "";
            }
        }
        catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }
    
    // ----------------------------------------------- METODOS DE APOYO -----------------------------------------------
    
    // Determina si existe un paciente
    public boolean existePaciente(int codigo) {
        
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente actualP = pacientes.get(i);
            int codigoAct = actualP.getCodigodelPaciente();
            if(codigo == codigoAct){
                return true;
            }
        }
        return false;
    }
    
    // Determina si existe un medico
    public boolean existeMedico(int codigo) {
        
        for (int i = 0; i < medicos.size(); i++) {
            Medico actualM = medicos.get(i);
            int codigoAct = actualM.getCodigoMedico();
            if(codigo == codigoAct){
                return true;
            }
        }
        return false;
    }
     
    // Determina el indice de un paciente en el array
    public int determinarIndexP(int codigo) {
        
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente actualP = pacientes.get(i);
            int codigoAct = actualP.getCodigodelPaciente();
            if(codigo == codigoAct){
                return i;
            }
        }
        // No se encontro el paciente
        return -1;
    }
    
    // Determina el indice de un medico en el array
    public int determinarIndexM(int codigo) {
        
        for (int i = 0; i < medicos.size(); i++) {
            Medico actualM = medicos.get(i);
            int codigoAct = actualM.getCodigoMedico();
            if(codigo == codigoAct){
                return i;
            }
        }
        // No se encontro el medico
        return -1;
    }
    
    // Determina el indice de una visita en el array
    private int determinarIndexV(int codigo) {
        for (int i = 0; i < visitas.size(); i++) {
            Visita actualV = visitas.get(i);
            int codigoAct = actualV.getNumVisita();
            if(codigo == codigoAct){
                return i;
            }
        }
        // No se encontro la visita
        return -1;
    }
    
    private Paciente getPaciente(int codigo){
        Paciente pac = new Paciente();
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacActual = pacientes.get(i);
            if (pacActual.getCodigodelPaciente() == codigo){
                pac = pacActual;
            }
        }
        return pac;
    }
    
    private Medico getMedico(int codigo){
        Medico med = new Medico();
        for (int i = 0; i < medicos.size(); i++) {
            Medico medActual = medicos.get(i);
            if (medActual.getCodigoMedico() == codigo){
                med = medActual;
            }
        }
        return med;
    }
    
    // ----------------------------------------------- DATOS DE PREUBA -----------------------------------------------
    public void Prueba() throws ParseException {
        
        // ---- PACIENTES DE PRUEBA
        Paciente p = new Paciente(1, 1111, "VALERIA", "F",
                new SimpleDateFormat("yyyy/mm/dd").parse("2002/07/30"), "Grecia", "Alajuela", 64576563);
        Paciente p2 = new Paciente(2, 2222, "ADRIANA", "F",
                new SimpleDateFormat("yyyy/mm/dd").parse("2000/10/08"), "Piedades", "San Jose", 61110815);
        Paciente p3 = new Paciente(3, 3333, "PAULA", "F",
                new SimpleDateFormat("yyyy/mm/dd").parse("2000/12/20"), "Liberia", "Guanacaste", 83044210);
        Paciente p4 = new Paciente(4, 4444, "OLGA", "F",
                new SimpleDateFormat("yyyy/mm/dd").parse("1989/03/01"), "Puerto Viejo", "Limon", 75430909);
        pacientes.add(p);
        pacientes.add(p2);
        pacientes.add(p3);
        pacientes.add(p4);
        
        // ---- MEDICOS DE PRUEBA ---
        Medico m = new Medico(1, 1111, "Juan", "Sibaja", "Otorrino", "Grecia", (float) 1050000.75, 73450906);
        Medico m1 = new Medico(2, 2222, "Jose", "Cespedes", "Medico General", "Liberia", (float) 1077000.50, 89897474);
        Medico m2 = new Medico(3, 3333, "Oscar", "Rojas", "OTORRINO", "Piedades", (float) 1088888.88, 64536765);
        Medico m3 = new Medico(4, 4444, "Ivan", "Hidalgo", "OTORRINO", "Puerto Viejo", (float) 1099999.99, 62145989);
        medicos.add(m);
        medicos.add(m1);
        medicos.add(m2);
        medicos.add(m3);
        
        // --- VISITAS DE PRUEBA ---
        Visita v = new Visita(1, new SimpleDateFormat("yyyy/mm/dd").parse("2021/12/13"), 1, 1, "Control");
        Visita v2 = new Visita(1, new SimpleDateFormat("yyyy/mm/dd").parse("2022/01/12"), 2, 2, "Control");
        Visita v3 = new Visita(1, new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/17"), 3, 3, "Control");
        Visita v4 = new Visita(1, new SimpleDateFormat("yyyy/mm/dd").parse("2021/10/30"), 4, 4, "Control");
        visitas.add(v);
        visitas.add(v2);
        visitas.add(v3);
        visitas.add(v4);
    }
}
   
