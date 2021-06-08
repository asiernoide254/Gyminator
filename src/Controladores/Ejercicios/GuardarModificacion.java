package Controladores.Ejercicios;

import BaseDeDatos.BaseDeDatos;
import Clases.Ejercicio;
import Clases.Usuario.Usuario;
import Menus.ClasesInterfaces.Interfaz;
import Menus.ClasesInterfaces.VentanaMensaje;
import Menus.Interfaces.ModificarDetallesEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GuardarModificacion implements ActionListener {
    private ModificarDetallesEjercicio modificacion;
    private Ejercicio ejercicio;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    public GuardarModificacion(ModificarDetallesEjercicio modif, Ejercicio ej){
        modificacion = modif;
        ejercicio = ej;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre =  modificacion.getNombre();
        int serie = 0;
        int repes = 0;
        double peso = 0;
        double tiempo = 0;
        Date fecha =  modificacion.getFecha();
        String sen = modificacion.getSensaciones();



        List<Ejercicio> ejerciciosUsuario = BaseDeDatos.getEjercicios(Interfaz.getUsuario().getEmail());

        //SERIES
        String se = modificacion.getSeries();
        try {
            if(!se.isEmpty())
                serie = Integer.parseInt(se);
        } catch (NumberFormatException ex){
            serie = -1;
        }

        //REPES
        String re = modificacion.getRepeticiones();
        try {
            if(!re.isEmpty())
                repes = Integer.parseInt(re);
        } catch (NumberFormatException ex){
            repes = -1;
        }


        //PESO
        String p = modificacion.getPeso();
        try {
            if(!p.isEmpty())
                peso = Double.parseDouble(p);
        } catch(NumberFormatException ex) {
            peso = -1;
        }

        //TIEMPO
        String t = modificacion.getTiempo();
        try {
            if(!t.isEmpty())
                tiempo = Double.parseDouble(t);
        } catch (NumberFormatException ex){
            tiempo = -1;
        }


        if (nombre.length() == 0){
            new VentanaMensaje("Nombre vacío");
        } else if(ejerciciosUsuario.contains(new Ejercicio(nombre, null)) && !nombre.equals(ejercicio.getNombre())) {
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
            String email = Interfaz.getUsuario().getEmail();
            BaseDeDatos.actualizarEjercicio(email, ejercicio.getNombre(), "CLIENTE", email,
                "NOMBRE", ej.getNombre(), "FECHA", formatter.format(ej.getFecha()),
                "SERIES", String.valueOf(ej.getSeries()), "REPETICIONES", String.valueOf(ej.getRepeticiones()),
                "PESO", String.valueOf(ej.getPeso()), "TIEMPO", String.valueOf(ej.getTiempo()),
                "SENSACIONES", ej.getSensaciones()
            );

            actualizarEjercicio(ej);
            
            new VentanaMensaje("Cambios aplicados.");
        }
    }

    private void actualizarEjercicio(Ejercicio ej){
        ejercicio.setNombre(ej.getNombre());
        ejercicio.setFecha(ej.getFecha());
        ejercicio.setSeries(ej.getSeries());
        ejercicio.setRepeticiones(ej.getRepeticiones());
        ejercicio.setPeso(ej.getPeso());
        ejercicio.setTiempo(ej.getTiempo());
        ejercicio.setSensaciones(ej.getSensaciones());
    }
}
