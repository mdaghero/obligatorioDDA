
package modelo;


public class Cliente {
    
    private TipoCliente tipoCliente;
    
    private String ci;
    
    private String nombre;
    
    private double saldo;

    public Cliente(TipoCliente tipoCliente, String ci, String nombre, double saldo) {
        this.tipoCliente = tipoCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
    
    
}
