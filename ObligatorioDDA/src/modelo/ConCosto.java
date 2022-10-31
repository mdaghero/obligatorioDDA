
package modelo;


public class ConCosto extends TipoCliente{

    @Override
    public double obtenerTarifa(long duracion, long tiempoEspera) {
        if(tiempoEspera < 60){
            return 1;
        } else {
            return 0.5;
        } 
    }

    @Override
    public double obtenerDescuento(long duracion, long tiempoEspera) {
       return 0;
    }
    
    
    
}
