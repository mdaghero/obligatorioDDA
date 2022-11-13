package controladores;

import javax.swing.JOptionPane;
import modelo.Fachada;
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
        if (evento.equals(Puesto.eventos.llamadaIniciada)) {
            vista.Mensaje("Llamada en curso...");
            vista.MensajeNombreCliente(puesto.getLlamadaEnCurso().getCliente().getNombre());
            vista.ToggleBotonFinalizar(true);
        } else if (evento.equals(Puesto.eventos.llamadaFinalizada)) {
            vista.Mensaje("Llamada finalizada. Duración: " + puesto.getLlamadasAtendidas().get(puesto.getLlamadasAtendidas().size() - 1).getDuracion()
                    + " segundos. Costo: $" + puesto.getLlamadasAtendidas().get(puesto.getLlamadasAtendidas().size() - 1).getCosto());
            vista.MensajeNombreCliente("");
            vista.ToggleBotonFinalizar(false);
            vista.mostrarDatos(trabajador, sector, puesto);
        }

    }

    public void finalizarLlamada(String descripcion) {
        if (puesto.getLlamadaEnCurso() != null) {
            puesto.getLlamadaEnCurso().setDescripcion(descripcion);
            Fachada.getInstancia().finalizarLlamada(puesto.getLlamadaEnCurso(), sector, puesto);
        }
    }

    public void logout() {
        if (puesto.getLlamadaEnCurso() == null) {
            puesto.logout();
            vista.Salir();
        } else {
            String mensaje = "Está seguro que desea salir y cancelar la llamada?";
            String titulo = "Logout";
            int reply = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                puesto.logout();
                this.finalizarLlamada("");
                vista.Salir();
            } 
        }

    }

}
