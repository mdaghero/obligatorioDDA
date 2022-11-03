
package controladores;

import javax.swing.JOptionPane;
import modelo.Fachada;


public class ControladorSimulador {
    
     private iVistaSimulador vista;
    
    public ControladorSimulador(iVistaSimulador vista){
        this.vista = vista;
    }
    
    public boolean hayCuposDisponibles(){
        return Fachada.getInstancia().hayCuposDisponibles();
    }
    
    public void iniciarLlamada(){
         if(Fachada.getInstancia().hayCuposDisponibles()){
            vista.Mensaje("Ingrese su cédula seguido de la tecla numeral");
        }else{
            vista.Mensaje("Comuníquese más tarde...");
        }
    }
    
}
