
package modelo;


public class Cliente {
    
    private TipoCliente tipoCliente;
    
    private String ci;
    
    private String nombre;
    
    private Integer saldo;

    public Cliente(TipoCliente tipoCliente, String ci, String nombre, Integer saldo) {
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

    public Integer getSaldo() {
        return saldo;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
    
    
    
    
    
}
