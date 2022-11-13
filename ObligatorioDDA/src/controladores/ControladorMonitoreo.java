
package controladores;

import modelo.Fachada;
import observador.Observable;
import observador.Observador;


public class ControladorMonitoreo implements Observador {

    private final iVistaMonitoreo vista;
 
    public ControladorMonitoreo(iVistaMonitoreo vista){
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        vista.cargarListaSectores(Fachada.getInstancia().getListaSectores());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(Fachada.eventos.cambioEstado.equals(evento)){
            vista.mostrarTabla();
        }
        
    }

    public void salir() {
        Fachada.getInstancia().quitarObservador(this);
    }

    
    
    
}
