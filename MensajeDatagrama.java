package SistemaGestranbanCliente-Servidor;

import java.net.*;

public class MensajeDatagrama {
    private String mensaje;
    private InetAddress direccionEmisor;
    private int puertoEmisor;

    public void fijaValor(String mensaje, InetAddress direccion, int puerto) {
        this.mensaje = mensaje;
        this.direccionEmisor = direccion;
        this.puertoEmisor = puerto;
    }

    public String obtieneMensaje() {
        return mensaje;
    }

    public InetAddress obtieneDireccion() {
        return direccionEmisor;
    }

    public int obtienePuerto() {
        return puertoEmisor;
    }
}

