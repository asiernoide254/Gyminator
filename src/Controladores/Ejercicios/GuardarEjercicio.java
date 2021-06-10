package Controladores.Ejercicios;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.RegistrarEjercicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class GuardarEjercicio implements ActionListener {
    private RegistrarEjercicio r;
    private JDialog j;

    public GuardarEjercicio(RegistrarEjercicio r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e){
      String nombre =  r.getNombre();
      int serie = 0;
      int repes = 0;
      double peso = 0;
      double tiempo = 0;
      Date fecha =  r.getFecha();
      String sen = r.getSensaciones();

      List<Ejercicio> ejerciciosUsuario = BaseDeDatos.getEjercicios(Interfaz.getUsuario().getEmail());

       //SERIES
        String se = r.getSeries();
        try {
            if(!se.isEmpty())
                serie = Integer.parseInt(se);
        } catch (NumberFormatException ex){
            serie = -1;
        }

        //REPES
            String re = r.getRepeticiones();
        try {
            if(!re.isEmpty())
                repes = Integer.parseInt(re);
        } catch (NumberFormatException ex){
            repes = -1;
        }


    //PESO
        String p = r.getPeso();
       try {
           if(!p.isEmpty())
               peso = Double.parseDouble(p);
       } catch(NumberFormatException ex) {
           peso = -1;
       }

       //TIEMPO
            String t = r.getTiempo();
        try {
            if(!t.isEmpty())
                tiempo = Double.parseDouble(t);
        } catch (NumberFormatException ex){
            tiempo = -1;
        }


        if (nombre.length() == 0){
            new VentanaMensaje("Nombre vacío");
        } else if(ejerciciosUsuario.contains(new Ejercicio(nombre, null))) {
            new VentanaMensaje("Ya tienes un ejercicio llamado " + nombre + ".");
        } else if (peso < 0){
            new VentanaMensaje("Peso incorrecto");
        }else if (repes < 0){
            new VentanaMensaje("repeticiones incorrectas");
        }else if (tiempo < 0){
            new VentanaMensaje("tiempo incorrecto");
        } else if (serie < 0){
             new VentanaMensaje("series incorrectas");
        }else {
            Ejercicio ej = new Ejercicio(nombre, serie, repes, peso, tiempo, fecha, sen);
            BaseDeDatos.addEjercicio(ej);
        }
    }


}
