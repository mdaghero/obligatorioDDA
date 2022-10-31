package modelo;

public class Gestores extends TipoCliente {

    @Override
    public double obtenerTarifa(long duracion, long tiempoEspera) {

        if (duracion > 180) {
            return 1;
        } else {
            return 0.5;

        }
    }

    @Override
    public double obtenerDescuento(long duracion, long tiempoEspera) {
        if(duracion <= 180){
            return tiempoEspera;
        }
        return 0;
    }

    
    
}
