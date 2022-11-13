package modelo;

import java.util.Date;
import observador.Observable;

public class Llamada extends Observable{

    private Costo costo;

    private Trabajador trabajador;
    
    private Integer numero;

    private Cliente cliente;

    private Date fechaInicio;

    private Date fechaFin;

    private Date fechaIngreso;

    private String descripcion;
    
    public enum eventos { puestoLibre, llamadaFinalizada }

    public long getDuracion() {
        return ((fechaFin.getTime() - fechaInicio.getTime()) / 1000);
    }

    public long getTiempoEspera() {
        return ((fechaInicio.getTime() - fechaIngreso.getTime()) / 1000);
    }

    public Llamada() {
        this.fechaIngreso = new Date();
        this.costo = new Costo();
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getCosto() {
        return costo.getCosto();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void finalizarLlamada() {
        this.fechaFin = new Date();
        double costoCliente = costo.calcularCosto(getDuracion(), getTiempoEspera(), cliente.getTipoCliente());
        this.cliente.setSaldo(cliente.getSaldo() - costoCliente);
        avisar(eventos.llamadaFinalizada);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void puestoLibre(){
        avisar(eventos.puestoLibre);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
    
}
