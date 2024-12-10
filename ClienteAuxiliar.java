package SistemaGestranbanCliente-Servidor;

import java.net.*;

public class ClienteAuxiliar {
    public static String enviarComando(String direccionServidor, String puerto, String comando) {
        String respuesta = "";
        try {
            InetAddress servidor = InetAddress.getByName(direccionServidor);
            int puertoServidor = Integer.parseInt(puerto);

            MiSocketDatagramaCliente socket = new MiSocketDatagramaCliente();
            socket.enviaMensaje(servidor, puertoServidor, comando);
            respuesta = socket.recibeMensaje();
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }
}
