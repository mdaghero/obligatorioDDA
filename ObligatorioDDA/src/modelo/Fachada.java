package modelo;

public class Fachada {

    private SistemaAcceso sAcceso = new SistemaAcceso();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public Trabajador Login(String ci, String pwd){
        return sAcceso.Login(ci, pwd);
    }
    
    
    public boolean asignarPuesto(Trabajador trabajador){
        return sAcceso.asignarPuesto(trabajador);
    }
    
    
}
