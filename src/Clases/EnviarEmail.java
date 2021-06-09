package Clases;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarEmail {

    private static final String HOST = "smtp.gmail.com";
    private static final int PUERTO = 587;
    private static final String USUARIO = "gyminator.app@gmail.com";
    private static final String PASSWORD = "EAB&TnUg8-wG!{*9";

    public EnviarEmail(String dest, String as, String cont) {
        enviar(dest, as, cont);
    }

    private void enviar(String destinatario, String asunto, String contenido) {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", HOST);
        prop.put("mail.smtp.port", PUERTO);
        prop.put("mail.smtp.ssl.trust", HOST);

        Session sesion = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USUARIO, PASSWORD);
            }
        });

        try {

            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress("email.para.mandar@gmail.com"));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setContent(contenido, "text/html");

            Transport.send(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}