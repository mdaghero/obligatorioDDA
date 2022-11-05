
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
    
    
    public boolean hayCuposDisponibles(){
        Integer acum = llamadasPendientes.size();
        for(Sector s: sectores){
            acum+=s.cantidadLlamadasEnCurso();
        }
        return acum<cantidadMax;
    }
    
    
    public Llamada iniciarLlamada(){
        Llamada ll = new Llamada();
        llamadasPendientes.add(ll);
        return ll;
    }

    void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    Cliente buscarCedula(String cadena) {
        for(Cliente c: clientes){
            if(c.getCi().equals(cadena)){
              return c;  
            }
        }
        return null;
    }
    
    public ArrayList<Sector> getListaSectores(){
        return sectores;
    }

    public Sector pedirSector(String num) {
        for(Sector s: sectores){
            if(s.getNumero() == Integer.parseInt(num)){
                return s;
            }
        }
        return null;
    }

    public boolean sectorDisponible(Sector sector) {
        return sector.sectorDisponible();
    }

    boolean asignarLlamada(Sector sector, Llamada llamada) {
        return sector.asignarLlamada(llamada);
    }
    
    
    
    
    
}
