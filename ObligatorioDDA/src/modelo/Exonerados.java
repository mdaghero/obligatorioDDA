
package modelo;


public class Exonerados extends TipoCliente {

    @Override
    public double obtenerTarifa(long duracion, long tiempoEspera) {
       return 0;
    }

    @Override
    public double obtenerDescuento(long duracion, long tiempoEspera) {
        return 0;
    }
    
        
    
}
