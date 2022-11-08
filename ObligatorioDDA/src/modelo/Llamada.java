package modelo;

import java.util.Date;

public class Llamada {

    private Costo costo;

    private Trabajador trabajador;

    private Cliente cliente;

    private Date fechaInicio;

    private Date fechaFin;

    private Date fechaIngreso;

    private String descripcion;

    public long getDuracion() {
        return ((fechaFin.getTime() - fechaInicio.getTime()) / 1000);
    }

    public long getTiempoEspera() {
        return ((fechaInicio.getTime() - fechaIngreso.getTime()) / 1000);
    }

//    public Llamada(Cliente cliente, Trabajador trabajador){
//        this.cliente = cliente;
//        this.trabajador = trabajador;
//        this.fechaInicio = new Date();
//        this.costo = new Costo();
//    }
    public Llamada() {
        this.fechaInicio = new Date();
        this.costo = new Costo();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void finalizarLlamada() {
        this.fechaFin = new Date();
        costo.calcularCosto(getDuracion(), getTiempoEspera(), cliente.getTipoCliente());
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
