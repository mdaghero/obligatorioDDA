
package controladores;

import modelo.Fachada;


public class ControladorMonitoreo {

    private final iVistaMonitoreo vista;
 
    public ControladorMonitoreo(iVistaMonitoreo vista){
        this.vista = vista;
        vista.cargarListaSectores(Fachada.getInstancia().getListaSectores());
    }


    
    
}
