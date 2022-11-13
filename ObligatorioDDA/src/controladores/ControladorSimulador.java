package controladores;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Llamada;
import modelo.LlamadasException;
import modelo.Puesto;
import modelo.Sector;
import observador.Observable;
import observador.Observador;

public class ControladorSimulador implements Observador {

    private iVistaSimulador vista;

    private String cadena = "";

    private Llamada llamada = null;

    private Puesto puesto = null;

    private Sector sector = null;

    public ControladorSimulador(iVistaSimulador vista) {
        this.vista = vista;

    }

    public void iniciarLlamada() {
        if (Fachada.getInstancia().hayCuposDisponibles()) {
            llamada = Fachada.getInstancia().iniciarLlamada();
            this.llamada.agregarObservador(this);
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
            } else if (sector == null) {
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
            pedirPuesto();
        } catch (LlamadasException ex) {
            vista.Mensaje(ex.getMessage());
        }
    }

    public void finalizarLlamada() {
        if (llamada != null) {
            vista.ToggleBotonFinalizar(false);
            vista.Mensaje("Llamada finalizada.");
            Fachada.getInstancia().finalizarLlamada(llamada, sector, puesto);
            limpiarCampos();
        }
           
    }
    
    private void pedirPuesto() {
        puesto = Fachada.getInstancia().asignarLlamada(sector, llamada);
        if (puesto != null) {
            vista.Mensaje("<html>Llamada en curso... <br> Ud. se está comunicando con el sector " + sector.getNombre() + ". <br>"
                    + " Y está siendo atendido por: " + puesto.getTrabajador().getNombre() + ". <br> Su llamada se ha iniciado en: "
                    + llamada.getFechaInicio() + "</html>");
        } else {
            vista.Mensaje("Aguarde en línea... Ud. se encuentra a " + sector.getLlamadasEnEspera().size() + " llamadas de ser \n"
                    + "atendido, la espera estimada es de " + sector.esperaEstimada() + " minutos.");
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Llamada.eventos.puestoLibre)) {
            pedirPuesto();
        }
        if (evento.equals(Llamada.eventos.llamadaFinalizada)) {
            vista.Mensaje("<html>Llamada finalizada. <br> Duración: " + llamada.getDuracion() + " segundos. <br> Costo: $"
                    + llamada.getCosto() + ". <br> Su saldo es de: $" + llamada.getCliente().getSaldo());
            vista.ToggleBotonFinalizar(false);
            llamada = null;
        }
    }
    
    public void limpiarCampos(){
        this.llamada = null;
        this.puesto = null;
        this.cadena = "";
        this.sector = null;
    }

}
