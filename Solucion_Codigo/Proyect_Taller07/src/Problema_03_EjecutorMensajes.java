import java.util.ArrayList;

/**
 * Problema 03: Sistema de envío de mensajes a móviles.
 * Implementa un sistema de envío de mensajes entre móviles.
 * Existen dos tipos de mensajes: SMS (texto) y MMS (imagen).
 * Cada mensaje tiene un remitente y un destinatario definidos por número de móvil.
 * @author Daniel Castillo
 * @version 1.0
 */
class Movil {
    public String numeroMovil;
    public String nombre;

    public Movil(String numeroMovil, String nombre) {
        this.numeroMovil = numeroMovil;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Movil{" + "numeroMovil=" + numeroMovil + ", nombre=" + nombre + '}';
    }
}

class Mensaje {
    public Movil remitente;
    public Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje() {
        System.out.println("Enviando mensaje de " + remitente.numeroMovil + " a " + destinatario.numeroMovil);
    }

    public void visualizarMensaje() {
        System.out.println("Remitente: " + remitente + " | Destinatario: " + destinatario);
    }

    @Override
    public String toString() {
        return "Mensaje{" + "remitente=" + remitente + ", destinatario=" + destinatario + '}';
    }
}

class SMS extends Mensaje {
    public String texto;

    public SMS(String texto, Movil remitente, Movil destinatario) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "SMS{" + "texto=" + texto + '}' + super.toString();
    }
}

class MMS extends Mensaje {
    public String nombreFichero;

    public MMS(String nombreFichero, Movil remitente, Movil destinatario) {
        super(remitente, destinatario);
        this.nombreFichero = nombreFichero;
    }

    @Override
    public String toString() {
        return "MMS{" + "nombreFichero=" + nombreFichero + '}' + super.toString();
    }
}

public class Problema_03_EjecutorMensajes {
    public static void main(String[] args) {
        Movil movil1 = new Movil("0991234567", "Daniel");
        Movil movil2 = new Movil("0987654321", "Andre");

        SMS sms1 = new SMS("Hola, como estas?", movil1, movil2);
        MMS mms1 = new MMS("foto_vacaciones.jpg", movil2, movil1);

        ArrayList<Mensaje> mensajes = new ArrayList<>();
        mensajes.add(sms1);
        mensajes.add(mms1);

        for (Mensaje m : mensajes) {
            System.out.println(m);
            System.out.println("---");
        }
    }
}
/**
 * run:
SMS{texto=Hola, como estas?}Mensaje{remitente=Movil{numeroMovil=0991234567, nombre=Daniel}, destinatario=Movil{numeroMovil=0987654321, nombre=Andre}}
---
MMS{nombreFichero=foto_vacaciones.jpg}Mensaje{remitente=Movil{numeroMovil=0987654321, nombre=Andre}, destinatario=Movil{numeroMovil=0991234567, nombre=Daniel}}
---
BUILD SUCCESSFUL (total time: 0 seconds)
 */