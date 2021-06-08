package Interfaces.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame implements Runnable, ActionListener {
    public static int onoff = 0;
    JLabel tiempo;
    Thread hilo;
    boolean cronometroActivo;
    boolean pausar;

    public Cronometro() {
        setTitle("Cronometro");
        setSize(500, 200);
        setLayout(new BorderLayout());

        //Etiqueta donde se colocara el tiempo
        tiempo = new JLabel("00:00:000");
        tiempo.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        tiempo.setHorizontalAlignment(JLabel.CENTER);
        tiempo.setForeground(Color.WHITE);
        tiempo.setBackground(Color.BLACK);
        tiempo.setOpaque(true);

        add(tiempo, BorderLayout.CENTER);

        //Boton iniciar
        JButton btn = new JButton("Iniciar");
        btn.addActionListener(this);
        add(btn, BorderLayout.NORTH);

        //Boton reiniciar inicia nuevamente desde 0
        JButton btnP = new JButton("Reiniciar");
        btnP.addActionListener(this);
        add(btnP, BorderLayout.EAST);

        JButton btnD = new JButton("Detener");
        btnD.addActionListener(this);
        add(btnD, BorderLayout.WEST);

        JButton btnSalir = new JButton("Salir");

        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void run() {
        Integer minutos = 0, segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min = "", seg = "", mil = "";
        try {

            while (pausar) {
                //Mientras cronometroActivo sea verdadero entonces seguira
                //aumentando el tiempo
                while (cronometroActivo) {
                    Thread.sleep(1);
                    //Incrementamos 4 milesimas de segundo
                    milesimas += 1;
                    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                    //y las milesimas de segundo de nuevo a 0
                    if (milesimas == 1000) {
                        milesimas = 0;
                        segundos += 1;
                        //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                        //y los segundos vuelven a 0
                        if (segundos == 60) {
                            segundos = 0;
                            minutos++;
                        }
                    }

                    //Esto solamente es estetica para que siempre este en formato
                    //00:00:000
                    if (minutos < 10) min = "0" + minutos;
                    else min = minutos.toString();
                    if (segundos < 10) seg = "0" + segundos;
                    else seg = segundos.toString();

                    if (milesimas < 10) mil = "00" + milesimas;
                    else if (milesimas < 100) mil = "0" + milesimas;
                    else mil = milesimas.toString();

                    //Colocamos en la etiqueta la informacion
                    tiempo.setText(min + ":" + seg + ":" + mil);
                /*while(pausar){
                    tiempo.setText( min + ":" + seg + ":" + mil );
                }*/
                }
                tiempo.setText(min + ":" + seg + ":" + mil);
            }
        } catch (Exception e) {
            System.out.println("Ya valió :P, error en el run");
        }
        //Cuando se reincie se coloca nuevamente en 00:00:000
        tiempo.setText("00:00:000");
    }

    //Esto es para el boton iniciar y reiniciar
    public void actionPerformed(ActionEvent evt) {
        Object o = evt.getSource();
        if (o instanceof JButton) {
            JButton btn = (JButton) o;
            if (btn.getText().equals("Iniciar")) {
                iniciarCronometro();
            }
            if (btn.getText().equals("Reiniciar")) {
                reiniciarCronometro();
            }
            if (btn.getText().equals("Detener")) {
                if (cronometroActivo) {
                    pararCronometro();
                } else
                    cronometroActivo = true;
            }
        }
    }

    //Iniciar el cronometro poniendo cronometroActivo
//en verdadero para que entre en el while
    public void iniciarCronometro() {
        cronometroActivo = true;
        pausar = true;
        hilo = new Thread(this);
        hilo.start();
    }

    //Esto es para parar el cronometro
    public void pararCronometro() {
        cronometroActivo = false;
        pausar = true;
    }

    public void reiniciarCronometro() {
        cronometroActivo = false;
        pausar = false;
    }
}