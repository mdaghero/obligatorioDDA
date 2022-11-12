
package modelo;


public class Costo {
    
    private static double costoFijo = 1;
    
    private double costo;

    public double getCosto() {
        return costo;
    }
    
    public double calcularCosto(long duracion, long tiempoEspera, TipoCliente tc){
        double tasa = tc.obtenerTarifa(duracion, tiempoEspera);
        double descuento = tc.obtenerDescuento(duracion, tiempoEspera);
        
        double costoFinal = costoFijo * duracion * tasa - (descuento * costoFijo);
        if(costoFinal < 0){
            costoFinal = 0;
        }
        this.costo = costoFinal;
        return costoFinal;
    }
    
}
