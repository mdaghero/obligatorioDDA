
package obligatoriodda.modelo;

import java.util.ArrayList;


public class Sector {
    
    private String nombre;
    
    private Integer numero;
    
    private Integer cantidadPuestos;
    
    private ArrayList<Llamada> llamadasEnEspera = new ArrayList<>();
    
    private ArrayList<Llamada> llamadasAtendidas = new ArrayList<>();
    
    private ArrayList<Puesto> puestos = new ArrayList<>();
    

    public Sector(String nombre, Integer numero, Integer cantidadPuestos) {  // 10 puestos asignados al sector
        this.nombre = nombre;
        this.numero = numero;
        this.cantidadPuestos = cantidadPuestos;
        for(int i=1; i <= cantidadPuestos; i++){
            puestos.add(new Puesto(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getCantidadPuestos() {
        return cantidadPuestos;
    }

    
    
    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    public ArrayList<Llamada> getLlamadasAtendidas() {
        return llamadasAtendidas;
    }


    public ArrayList<Puesto> getPuestos(){
        return puestos;
    }
    
    public boolean asignarTrabajadorAPuesto(Trabajador trabajador){
        for(Puesto p: puestos){
            if(p.getTrabajador() != null){
                p.setTrabajador(trabajador);
                return true;
            }
        }
        return false;
    }
    
    
}
