package SistemaGestranbanCliente-Servidor;

import java.net.*;
import java.io.*;

public class MiSocketDatagramaCliente extends DatagramSocket {
    static final int MAX_LARGO = 100;

    public MiSocketDatagramaCliente() throws SocketException {
        super();
    }

    public void enviaMensaje(InetAddress direccionServidor, int puertoServidor, String mensaje) throws IOException {
        byte[] bufferEnvio = mensaje.getBytes();
        DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionServidor, puertoServidor);
        this.send(paqueteEnvio);
    }

    public String recibeMensaje() throws IOException {
        byte[] bufferRecepcion = new byte[MAX_LARGO];
        DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, MAX_LARGO);
        this.receive(paqueteRecepcion);
        return new String(bufferRecepcion).trim();
    }
}
