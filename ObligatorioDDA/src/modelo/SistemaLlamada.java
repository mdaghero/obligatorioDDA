package modelo;

import java.util.ArrayList;

public class SistemaLlamada {

    private Integer cantidadMax = 5;

    public ArrayList<Sector> sectores = new ArrayList<>();

    public ArrayList<Llamada> llamadasPendientes = new ArrayList<>();

    public ArrayList<Cliente> clientes = new ArrayList<>();

    void agregarSector(Sector sector1) {
        sectores.add(sector1);
    }

    public boolean hayCuposDisponibles() {
        Integer acum = llamadasPendientes.size();
        for (Sector s : sectores) {
            acum += s.cantidadLlamadasEnCurso();
        }
        return acum < cantidadMax;
    }

    public Llamada iniciarLlamada() {
        Llamada ll = new Llamada();
        llamadasPendientes.add(ll);
        return ll;
    }

    void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    Cliente buscarCedula(String cadena) {
        for (Cliente c : clientes) {
            if (c.getCi().equals(cadena)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Sector> getListaSectores() {
        return sectores;
    }

    public Sector pedirSector(String num) throws LlamadasException {
        for (Sector s : sectores) {
            if (s.getNumero() == Integer.parseInt(num)) {
                return s;
            }
        }
        throw new LlamadasException("Sector no válido");
    }

    public void sectorDisponible(Sector sector) throws LlamadasException {
        sector.sectorDisponible();
    }

    public Puesto asignarLlamada(Sector sector, Llamada llamada) {
        llamadasPendientes.remove(llamada);
        return sector.asignarLlamada(llamada);
    }

    void finalizarLlamada(Llamada llamada, Sector sector, Puesto puesto) {
        if (sector != null) {
            if (llamada.getFechaInicio() != null) {
                llamada.finalizarLlamada();
                puesto.finalizarLlamada();
            }
            sector.finalizarLlamada(llamada);
        }else{
            this.llamadasPendientes.remove(llamada);
        }
    }

}
