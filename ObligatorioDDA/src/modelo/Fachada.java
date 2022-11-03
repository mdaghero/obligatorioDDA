package modelo;

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
    
    

}
