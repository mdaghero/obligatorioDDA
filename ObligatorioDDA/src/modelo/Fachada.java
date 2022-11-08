package modelo;

import java.util.ArrayList;

public class Fachada {

    private SistemaAcceso sAcceso = new SistemaAcceso();

    private SistemaLlamada sLlamada = new SistemaLlamada();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public Trabajador Login(String ci, String pwd) {
        return sAcceso.Login(ci, pwd);
    }

    public void agregarTrabajador(Trabajador trabajador) {
        sAcceso.agregarTrabajador(trabajador);
    }

    public boolean asignarPuesto(Trabajador trabajador) {
        return sAcceso.asignarPuesto(trabajador);
    }

    public void agregarSector(Sector sector1) {
        sLlamada.agregarSector(sector1);
    }
    
    public boolean hayCuposDisponibles(){
        return sLlamada.hayCuposDisponibles();
    }

    public Llamada iniciarLlamada() {
        return sLlamada.iniciarLlamada();
    }
    
    public void agregarCliente(Cliente cliente){
        sLlamada.agregarCliente(cliente);
    }

    public Cliente buscarCedula(String cadena) {
        return sLlamada.buscarCedula(cadena);
    }
    
    public ArrayList<Sector> getListaSectores(){
        return sLlamada.getListaSectores();
    }

    public Sector pedirSector(String num) throws LlamadasException{
        return sLlamada.pedirSector(num);
    }

    public void sectorDisponible(Sector sector) throws LlamadasException {
        sLlamada.sectorDisponible(sector);
    }

    public Puesto asignarLlamada(Sector sector, Llamada llamada) {
        return sLlamada.asignarLlamada(sector, llamada);
    }
    
    
    

}
