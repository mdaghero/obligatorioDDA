package controladores;

import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;
import observador.Observable;
import observador.Observador;

public class ControladorLlamadas implements Observador {

    private iVistaAtenderLlamadas vista;

    private Trabajador trabajador;
    
    private Sector sector;
    
    private Puesto puesto;

    public ControladorLlamadas(Trabajador trabajador, iVistaAtenderLlamadas vista) {
        this.vista = vista;
        this.trabajador = trabajador;
        this.sector = trabajador.getSector();
        this.puesto = sector.getPuestoPorTrabajador(trabajador);
        this.puesto.agregarObservador(this);
        vista.mostrarDatos(trabajador, sector, puesto);
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Puesto.eventos.llamadaIniciada)){
            vista.Mensaje("Llamada en curso...");
        }else if(evento.equals(Puesto.eventos.llamadaFinalizada)){
            vista.Mensaje("Llamada finalizada.");
        }
        
    }

}
