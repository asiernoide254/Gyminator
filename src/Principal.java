import BaseDeDatos.BaseDeDatos;
import Menus.ClasesInterfaces.Interfaz;
import Menus.Interfaces.InicioSesion;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BaseDeDatos.conectar();

            Interfaz.setVentana(new InicioSesion());
        });
    }
}
