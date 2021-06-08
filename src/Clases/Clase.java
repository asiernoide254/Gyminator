package Clases;

import Clases.Usuario.Cliente;
import Clases.Usuario.Entrenador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clase {

    private int codigo;
    private Entrenador entrenador;
    private int plazasRestantes;
    private Date fecha;
    private String hora;
    private List<Cliente> ListaEspera = new ArrayList<>();
    private List<Cliente> participantes = new ArrayList<>();

    public Clase(int codigo, int plazasRestantes, Date fecha, String hora, Entrenador entrenador) {
        this.codigo = codigo;
        this.plazasRestantes = plazasRestantes;
        this.fecha = fecha;
        this.hora = hora;
        this.entrenador = entrenador;
    }

    //Añade un cliente a la lista de espera (clase llena)
    public void addListaEspera(Cliente c) {
        ListaEspera.add(c);
    }

    //Añade un cliente a la lista de participantes (clase no llena)
    public void addParticipante(Cliente c) {
        participantes.add(c);
    }

    public int getPlazasRestantes() {
        return plazasRestantes;
    }

    public void PlazaRestanteMenos(){
        if(plazasRestantes > 0){
            plazasRestantes--;
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int c) {
        codigo = c;
    }

    public String InfoBasica() {
        String clase = "Nº " + codigo + " | Plazas Restantes: " + plazasRestantes + " | Hora: " + hora;

        return clase;
    }
}
