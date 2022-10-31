
package modelo;


public abstract class TipoCliente {
    
    public abstract double obtenerTarifa(long duracion, long tiempoEspera);
    
    public abstract double obtenerDescuento(long duracion, long tiempoEspera);
    
}
