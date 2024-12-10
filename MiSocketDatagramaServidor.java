package SistemaGestranbanCliente-Servidor;

import java.net.*;
import java.io.*;

public class MiSocketDatagramaServidor extends DatagramSocket {
    static final int MAX_LARGO = 100;

    public MiSocketDatagramaServidor(int puerto) throws SocketException {
        super(puerto);
    }

    public void enviaMensaje(InetAddress direccionReceptora, int puertoReceptor, String mensaje) throws IOException {
        byte[] bufferEnvio = mensaje.getBytes();
        DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionReceptora, puertoReceptor);
        this.send(paqueteEnvio);
    }

    public MensajeDatagrama recibeMensajeYEmisor() throws IOException {
        byte[] bufferRecepcion = new byte[MAX_LARGO];
        DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, MAX_LARGO);
        this.receive(paqueteRecepcion);

        MensajeDatagrama mensaje = new MensajeDatagrama();
        mensaje.fijaValor(new String(bufferRecepcion).trim(), paqueteRecepcion.getAddress(), paqueteRecepcion.getPort());
        return mensaje;
    }
}

