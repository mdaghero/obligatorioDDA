
package controladores;

import modelo.Fachada;
import modelo.Trabajador;
import vistas.vistaAtenderLlamadas;




public class ControladorLogin {

    private iVistaLogin vista;
    
    public ControladorLogin(iVistaLogin vista){
        this.vista = vista;
    }
    
    public Trabajador Login(String ci, String pwd){
        return Fachada.getInstancia().Login(ci, pwd);
    }
   
    public boolean asignarPuesto(Trabajador trabajador){
        return Fachada.getInstancia().asignarPuesto(trabajador);
    }
    
    public void atenderLlamadas(Trabajador trabajador){
        new vistaAtenderLlamadas(null, false, trabajador).setVisible(true);
    }
    
    
}
