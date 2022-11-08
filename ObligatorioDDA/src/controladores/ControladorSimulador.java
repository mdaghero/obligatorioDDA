package controladores;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Llamada;
import modelo.LlamadasException;
import modelo.Puesto;
import modelo.Sector;

public class ControladorSimulador {
    
    private iVistaSimulador vista;
    
    private String cadena = "";
    
    private Llamada llamada = null;
    
    private Sector sector = null;
    
    public ControladorSimulador(iVistaSimulador vista) {
        this.vista = vista;
    }
    
    public void iniciarLlamada(){
        if (Fachada.getInstancia().hayCuposDisponibles()) {
            llamada = Fachada.getInstancia().iniciarLlamada();
            vista.Mensaje("Ingrese su cédula seguido de la tecla numeral");
        } else {
            vista.Mensaje("Comuníquese más tarde...");
        }
    }
    
    public void ingresarTecla(String string) {
        
        if (llamada != null) {
            if (llamada.getCliente() == null) {
                if (string.equals("#")) {
                    enviarDatos();
                } else {
                    cadena += string;
                }
            } else {
                pedirSector(string);
            }
        }
        
    }
    
    public void enviarDatos() {
        llamada.setCliente(Fachada.getInstancia().buscarCedula(cadena)); //buscarClientePorCedula()
        if (llamada.getCliente() != null) {
            ArrayList<Sector> sectores = Fachada.getInstancia().getListaSectores();
            String mensaje = "Para comunicarse con ";
            for (Sector s : sectores) {
                mensaje += s.getNombre() + " digite " + s.getNumero() + ", ";
            }
            vista.Mensaje(mensaje);
        } else {
            vista.Mensaje("Cliente no registrado");
        }
    }
    
    public void pedirSector(String num) {
        
        try {
            sector = Fachada.getInstancia().pedirSector(num);
            Fachada.getInstancia().sectorDisponible(sector);
            Puesto puesto = Fachada.getInstancia().asignarLlamada(sector, llamada);
            if (puesto != null) {
                vista.Mensaje("Llamada en curso... Ud. se está comunicando con el sector " + sector.getNombre() + ". \n"
                        + " Y está siendo atendido por: \n"
                        + puesto.getTrabajador().getNombre() + ". Su llamada se ha iniciado en: " + llamada.getFechaInicio());
            } else {
                vista.Mensaje("Aguarde en línea... Ud. se encuentra a " + sector.getLlamadasEnEspera().size() + " llamadas de ser \n"
                        + "atendido, la espera estimada es de " + sector.esperaEstimada() + " minutos.");
            }
        } catch (LlamadasException ex) {
            vista.Mensaje(ex.getMessage());
        }
        
    }
    
}
