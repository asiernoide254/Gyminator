package BaseDeDatos;

import Clases.Clase;
import Clases.Ejercicio;
import Clases.Gimnasio;
import Clases.Usuario.Cliente;
import Clases.Usuario.Entrenador;
import Clases.Usuario.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class BaseDeDatos {
    static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";

    static final String URL_BD = "jdbc:mysql://iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String ESQUEMA_BD = "grupoB";

    static final String USUARIO = "usuarioB";
    static final String PASSWORD = "rocaparra";

    private static Connection conexion;
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private BaseDeDatos() {
    }

    public static void conectar() {
        try {
            Class.forName(DRIVER_JDBC);
            conexion = DriverManager.getConnection(URL_BD + "/" + ESQUEMA_BD, USUARIO, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado.");
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
    }

    private static String darFormato(String s) {
        return s == null ? "null" : "'" + s + "'";
    }

    private static String getCondiciones(String delimitador, String[] valores) {
        StringJoiner sj = new StringJoiner(delimitador);
        for (int i = 1; i < valores.length; i += 2)
            sj.add(valores[i - 1] + " = " + darFormato(valores[i]));

        return sj.toString();
    }

    private static ResultSet hacerConsulta2(String consulta) {
        ResultSet resultado = null;
        try {
            resultado = conexion.prepareStatement(consulta).executeQuery();
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return resultado;
    }

    private static ResultSet hacerConsulta(String tabla, String... valores) {
        String consulta = "SELECT * FROM " + tabla;
        if (valores.length > 0)
            consulta += " WHERE " + getCondiciones(" AND ", valores);

        return hacerConsulta2(consulta);
    }

    private static void modificar(String comando) {
        try {
            conexion.prepareStatement(comando).executeUpdate();
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
    }

    private static void insertar(String tabla, String... valores) {
        StringJoiner sj = new StringJoiner(", ");
        for (String valor : valores)
            sj.add(darFormato(valor));

        String comando = "INSERT INTO " + tabla + " VALUES (" + sj + ")";
        modificar(comando);
    }

    private static void actualizar(String tabla, String[] clave, String[] valores) {
        String comando = "UPDATE " + tabla + " SET " + getCondiciones(", ", valores) + " WHERE " + getCondiciones(" AND ", clave);
        modificar(comando);
    }

    private static void eliminar(String tabla, String... valores) {
        String comando = "DELETE FROM " + tabla;
        if (valores.length > 0)
            comando += " WHERE " + getCondiciones(" AND ", valores);
        modificar(comando);
    }

    public static Usuario getUsuario(String email) {
        ResultSet datosUsuario = hacerConsulta("USUARIO", "EMAIL", email);
        Usuario usuario = new Cliente();

        try {
            if (datosUsuario.next()) {
                usuario.setEmail(datosUsuario.getString(1));
                usuario.setPassword(datosUsuario.getString(2));
                usuario.setNombre(datosUsuario.getString(3));
                usuario.setApellidos(datosUsuario.getString(4));
                usuario.setFechaNacimiento(datosUsuario.getDate(5));
                usuario.setGenero(datosUsuario.getString(6));
                usuario.setTelefono(datosUsuario.getString(7));
                usuario.setFoto(datosUsuario.getString(8));
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return usuario;
    }

    public static void addUsuario(Usuario usuario) {
        insertar("USUARIO", usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(),
                formatter.format(usuario.getFechaNacimiento()), usuario.getGenero(), usuario.getTelefono(), null);
    }

    //BaseDeDatos.actualizarUsuario(0612330111@uma.es, "NOMBRE", "Asier", "EMAIL", "nuevoEmail@uma.es")
    public static void actualizarUsuario(String email, String... valores) {
        actualizar("USUARIO", new String[]{"EMAIL", email}, valores);
    }

    public static void actualizarEntrenador(String email, String... valores) {
        actualizar("ENTRENADOR", new String[]{"EMAIL", email}, valores);
    }

    public static void eliminarUsuario(String email) {
        eliminar("USUARIO", "EMAIL", email);
    }

    public static void addGimnasio(Gimnasio gimnasio) {
        insertar("GIMNASIO", gimnasio.getId() + "", gimnasio.getNombre(), gimnasio.getDireccion());
    }

    public static void actualizarGimnasio(int codigo, String... valores) {
        actualizar("GIMNASIO", new String[]{"CODIGO", codigo + ""}, valores);
    }

    public static void eliminarGimnasio(int codigo) {
        eliminar("GIMNASIO", "CODIGO", codigo + "");
    }

    public static void addClase(Clase clase) {
        insertar("CLASE", clase.getCodigo() + "", clase.getFecha().toString(), clase.getHora(),
                clase.getEntrenador().getEmail(), clase.getPlazasRestantes() + "");
    }

    public static void actualizarClase(int codigo, String... valores) {
        actualizar("CLASE", new String[]{"CODIGO", codigo + ""}, valores);
    }

    public static void eliminarClase(int codigo) {
        eliminar("CLASE", "CODIGO", codigo + "");
    }

    public static void addEjercicio(Ejercicio ej) {
        insertar("EJERCICIO", ej.getNombre() + "", ej.getFecha() + "", ej.getSeries() + "", ej.getRepeticiones() + "", ej.getPeso() + "",
                ej.getTiempo() + "", ej.getSensaciones());
    }

    public static List<Ejercicio> getEjercicios(String email) {
        ResultSet datosEjercicio = hacerConsulta("EJERCICIO", "EMAIL", email);
        List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();


        try {
            while (datosEjercicio.next()) {
                String nombre = datosEjercicio.getString(1);
                Date fecha = datosEjercicio.getDate(2);
                int series = datosEjercicio.getInt(3);
                int rep = datosEjercicio.getInt(4);
                double peso = datosEjercicio.getDouble(5);
                double tiempo = datosEjercicio.getDouble(6);
                String sens = datosEjercicio.getString(7);
                ejercicios.add(new Ejercicio(nombre, series, rep, peso, tiempo, fecha, sens));

            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return ejercicios;
    }

    public static void eliminarEjercicio(Ejercicio e, Usuario u) {
        // eliminar("EJERCICIO", "CLIENTE", u.getEmail(), "FECHA", e.getDate());
    }

    public static List<Clase> getClasesDisponibles(Date fecha) {
        ResultSet reservas = hacerConsulta("CLASE", "FECHA", fecha.toString());
        List<Clase> clases = new ArrayList<Clase>();
        int cdg, pRest;
        String hora;
        Entrenador entrenador;
        Clase aux;

        try {
            while (reservas.next()) {
                cdg = reservas.getInt(1);
                hora = reservas.getString(3);
                pRest = reservas.getInt(5);
                entrenador = getEntrenador(reservas.getString(4));
                aux = new Clase(cdg, pRest, fecha, hora, entrenador);

                clases.add(aux);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return clases;
    }


    public static Entrenador getEntrenador(String email) {
        ResultSet datosEntrenador = hacerConsulta("ENTRENADOR", "EMAIL", email);
        Usuario usuario = getUsuario(email);
        Entrenador entrenador = new Entrenador();

        try {
            if (datosEntrenador.next() && email.equals(usuario.getEmail())) {
                String em = usuario.getEmail();
                String pass = usuario.getPassword();
                String n = usuario.getNombre();
                String ap = usuario.getApellidos();
                Date fecha = usuario.getFechaNacimiento();
                String gen = usuario.getGenero();
                String tlf = usuario.getTelefono();
                String foto = usuario.getFoto();
                entrenador = new Entrenador(em, pass, n, ap, fecha, gen, tlf, foto);

                entrenador.setBiografia(datosEntrenador.getString(3));
                entrenador.setHorasDeTrabajo(datosEntrenador.getDouble(2));
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return entrenador;
    }


    public static List<Integer> getCodigosPassword(String email) {
        List<Integer> codigos = new ArrayList<>();

        ResultSet resultado = hacerConsulta("CODIGO_PASSWORD", "USUARIO", email);

        try {
            while (resultado.next()) {
                codigos.add(resultado.getInt(1));
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return codigos;
    }

    public static List<Integer> getCodigosPassword() {
        List<Integer> codigos = new ArrayList<>();

        ResultSet resultado = hacerConsulta("CODIGO_PASSWORD");

        try {
            while (resultado.next()) {
                codigos.add(resultado.getInt(1));
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }

        return codigos;
    }

    public static void addCodigoPassword(int codigo, String email) {
        insertar("CODIGO_PASSWORD", codigo + "", email);
    }

    public static void borrarCodigosPassword(String email) {
        eliminar("CODIGO_PASSWORD", "USUARIO", email);
    }


}
