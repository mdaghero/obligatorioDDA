package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Sector {
    
    private Integer numeroLlamadaSector = 1;
    
    private String nombre;

    private Integer numero;

    private Integer cantidadPuestos;

    private ArrayList<Llamada> llamadasEnEspera = new ArrayList<>();

    private ArrayList<Llamada> llamadasAtendidas = new ArrayList<>();

    private ArrayList<Puesto> puestos = new ArrayList<>();

    public enum eventos {
        puestoLibre
    };

    public Sector(String nombre, Integer numero, Integer cantidadPuestos) {  // 10 puestos asignados al sector
        this.nombre = nombre;
        this.numero = numero;
        this.cantidadPuestos = cantidadPuestos;
        for (int i = 1; i <= cantidadPuestos; i++) {
            puestos.add(new Puesto(i));
        }
    }


    public void setNumeroLlamada(Integer numeroLlamadaSector) {
        this.numeroLlamadaSector = numeroLlamadaSector;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getCantidadPuestos() {
        return cantidadPuestos;
    }

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    public ArrayList<Llamada> getLlamadasAtendidas() {
        return llamadasAtendidas;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public boolean asignarTrabajadorAPuesto(Trabajador trabajador) {
        for (Puesto p : puestos) {
            if (p.getTrabajador() == null) {
                p.setTrabajador(trabajador);
                if (!this.llamadasEnEspera.isEmpty()) {
                    llamadasEnEspera.get(0).puestoLibre();
                }

                return true;
            }
        }
        return false;
    }

    public Puesto getPuestoPorTrabajador(Trabajador trabajador) {
        for (Puesto p : puestos) {
            if (p.getTrabajador().equals(trabajador)) {
                return p;
            }
        }
        return null;
    }

    public Integer cantidadLlamadasEnCurso() {
        Integer cant = 0;

        for (Puesto p : puestos) {
            if (p.getLlamadaEnCurso() != null) {
                cant++;
            }
        }
        return cant + llamadasEnEspera.size();
    }

    public void sectorDisponible() throws LlamadasException {
        boolean bandera = false;
        for (Puesto p : puestos) {
            if (p.getTrabajador() != null) {
                bandera = true;
            }
        }
        if (!bandera) {
            throw new LlamadasException("Sector no disponible");
        }
    }

    public Puesto asignarLlamada(Llamada llamada) {
        if(!llamadasEnEspera.contains(llamada)) llamada.setNumero(numeroLlamadaSector++);
        for (Puesto p : puestos) {
            if (p.getTrabajador() != null && p.getLlamadaEnCurso() == null) {
                llamada.setFechaInicio(new Date());
                llamada.setTrabajador(p.getTrabajador());
                p.setLlamadaEnCurso(llamada);
                this.llamadasEnEspera.remove(llamada);
                return p;
            }
        }
        if(!llamadasEnEspera.contains(llamada)) this.llamadasEnEspera.add(llamada);
        return null;
    }

    private double promedioPuestos() {
        double acum = 0;
        for (Puesto p : puestos) {
            acum += p.calcularPromedioDeEspera();
        }
        if (!puestos.isEmpty()) {
            return acum / puestos.size();
        }
        return 0;
    }

    public double esperaEstimada() {
        return (promedioPuestos() * this.getLlamadasEnEspera().size());
    }

    void finalizarLlamada(Llamada llamada) {
        if (llamada.getFechaInicio() == null) {
            this.llamadasEnEspera.remove(llamada);
        } else {
            this.llamadasAtendidas.add(llamada);
            if (!this.llamadasEnEspera.isEmpty()) {
                llamadasEnEspera.get(0).puestoLibre();
                //for(Llamada l:llamadasEnEspera) {l.puestoLibre();}
            }
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
}
