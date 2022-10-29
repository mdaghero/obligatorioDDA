package obligatoriodda.modelo;

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

}
