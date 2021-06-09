package Clases;


import Clases.Usuario.Cliente;
import Clases.Usuario.Entrenador;
import Clases.Usuario.Propietario;

import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private int id;
    private String nombre;
    private String direccion;
    private List<Propietario> propietarios;
    private List<Entrenador> entrenadores;
    private List<Cliente> clientes;

    public Gimnasio(int i, String n, String d) {
        id = i;
        nombre = n;
        direccion = d;
        propietarios = new ArrayList<>();
        entrenadores = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String d) {
        direccion = d;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void addPropietario(Propietario p) {
        propietarios.add(p);
    }

    public void removePropietario(Propietario p) {
        propietarios.remove(p);
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void addEntrenador(Entrenador e) {
        entrenadores.add(e);
    }

    public void removeEntrenador(Entrenador e) {
        entrenadores.remove(e);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void removeCliente(Cliente c) {
        clientes.remove(c);
    }


}
