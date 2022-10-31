
package modelo;


public class Trabajador {
    
    private Integer ci;
    
    private String pass;
    
    private String nombre;
    
    private Sector sector;

    public Trabajador(Integer ci, String pass, Sector sector, String nombre) {
        this.ci = ci;
        this.pass = pass;
        this.sector = sector;
        this.nombre = nombre;
    }

    public Integer getCi() {
        return ci;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }
        
    public Sector getSector(){
        return sector;
    }
    
    public boolean asignarPuesto(){
        return sector.asignarTrabajadorAPuesto(this);
    }
    
    
    
}
