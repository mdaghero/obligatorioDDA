package modelo;

import java.util.ArrayList;

public class SistemaAcceso {

    ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

    public Trabajador Login(String ci, String pwd) {
        for (Trabajador trab : trabajadores) {
            if (trab.getCi().equals(ci) && trab.getPass().equals(pwd)) {
                return trab;
            }
        }
        return null;
    }

    public boolean asignarPuesto(Trabajador trabajador) {
        if (trabajador != null) {
            return trabajador.asignarPuesto();
        }
        return false;
    }

    void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    
}
