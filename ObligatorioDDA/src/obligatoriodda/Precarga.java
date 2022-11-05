package obligatoriodda;

import modelo.Cliente;
import modelo.ConCosto;
import modelo.Exonerados;
import modelo.Fachada;
import modelo.Gestores;
import modelo.Sector;
import modelo.Trabajador;

public class Precarga {

    public static void cargar() {

        Fachada logica = Fachada.getInstancia();

        Sector sector1 = new Sector("Ventas", 1, 8);
        Sector sector2 = new Sector("Administracion", 2, 6);
        Sector sector3 = new Sector("Servicio Tecnico", 3, 5);
        Sector sector4 = new Sector("Posventa", 4, 4);

        logica.agregarSector(sector1);
        logica.agregarSector(sector2);
        logica.agregarSector(sector3);
        logica.agregarSector(sector4);
        
        logica.agregarTrabajador(new Trabajador("11111111", "1", sector1, "Juan Perez"));
        logica.agregarTrabajador(new Trabajador("22222222", "2", sector3, "Martin Gomez"));
        logica.agregarTrabajador(new Trabajador("33333333", "3", sector2, "Laura Rodriguez"));
        logica.agregarTrabajador(new Trabajador("44444444", "4", sector4, "Ana Gonzalez"));
        logica.agregarTrabajador(new Trabajador("55555555", "5", sector1, "Felipe Garcia"));

        logica.agregarCliente(new Cliente(new ConCosto(), "77777777", "Lucia Perez", 2300));
        logica.agregarCliente(new Cliente(new Exonerados(), "88888888", "Matias Rodriguez", 500));
        logica.agregarCliente(new Cliente(new Gestores(), "77777777", "Elena Silvera", 1230));
        
    }

}
