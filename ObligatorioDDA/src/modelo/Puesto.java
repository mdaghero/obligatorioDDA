package modelo;

import java.util.ArrayList;

public class Puesto {

    private Integer numero;

    private Trabajador trabajador;

    private Llamada llamadaEnCurso;

    private ArrayList<Llamada> llamadasAtendidas = new ArrayList<>();

    public Puesto(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Llamada getLlamadaEnCurso() {
        return llamadaEnCurso;
    }

    public void setLlamadaEnCurso(Llamada llamadaEnCurso) {
        this.llamadaEnCurso = llamadaEnCurso;
    }

    public ArrayList<Llamada> getLlamadasAtendidas() {
        return llamadasAtendidas;
    }

    public void setLlamadasAtendidas(ArrayList<Llamada> llamadasAtendidas) {
        this.llamadasAtendidas = llamadasAtendidas;
    }

    public double calcularPromedio(){
        double acum = 0;
        for(Llamada ll: llamadasAtendidas){
            acum += ll.getDuracion();
        }
        if(!llamadasAtendidas.isEmpty()) return acum / llamadasAtendidas.size();
        return 0;
    }

    public double calcularPromedioDeEspera(){
        double acum = 0;
        for(Llamada ll: llamadasAtendidas){
            acum += ll.getTiempoEspera();
        }
        if(!llamadasAtendidas.isEmpty()) return acum / llamadasAtendidas.size();
        return 0;
    }
    
    
    
}
