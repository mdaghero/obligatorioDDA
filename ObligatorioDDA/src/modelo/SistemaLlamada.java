
package modelo;

import java.util.ArrayList;


public class SistemaLlamada {
    
    private Integer cantidadMax = 5;
    
    public ArrayList<Sector> sectores = new ArrayList<>();

    void agregarSector(Sector sector1) {
        sectores.add(sector1);
    }
    
    
    public boolean hayCuposDisponibles(){
        Integer acum = 0;
        for(Sector s: sectores){
            acum+=s.cantidadLlamadasEnCurso();
        }
        return acum<cantidadMax;
    }
    
    
}
