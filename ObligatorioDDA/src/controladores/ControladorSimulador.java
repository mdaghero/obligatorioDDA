package controladores;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;

public class ControladorSimulador {

    private iVistaSimulador vista;

    String cadena = "";

    Llamada llamada = null;

    Sector sector = null;

    public ControladorSimulador(iVistaSimulador vista) {
        this.vista = vista;
    }

    public void iniciarLlamada() {
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
        sector = Fachada.getInstancia().pedirSector(num);
        if (sector != null) {
            if (Fachada.getInstancia().sectorDisponible(sector)) {
                if (Fachada.getInstancia().asignarLlamada(sector, llamada)) {

                } else {
                    vista.Mensaje("Aguarde en línea, Ud. se encuentra a " + " "  + " llamadas de ser\n" 
                            + "atendido, la espera estimada es de N minutos” Siendo X la cantidad de llamadas en\n"
                            + "espera para ese sector y N los minutos estimados de espera para el sector");
                }

            } else {
                vista.Mensaje("Sector no disponible");
            }
        } else {
            vista.Mensaje("Sector no válido");
        }

    }

}
