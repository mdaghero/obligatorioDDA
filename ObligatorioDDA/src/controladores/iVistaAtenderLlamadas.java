
package controladores;

import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;

public interface iVistaAtenderLlamadas {

    public void mostrarDatos(Trabajador trabajador, Sector sector, Puesto puesto);
    
    public void Mensaje(String msje);
    
    public void MensajeNombreCliente(String mensaje);

    public void ToggleBotonFinalizar(Boolean habilitado);

    
}
