package SistemaGestranbanCliente-Servidor;

import java.net.*;
import java.util.*;

public class ServidorCentral {
    private static final int PUERTO = 6000; // Puerto del servidor
    private static final Map<String, List<String>> historialSucursales = new HashMap<>();

    public static void main(String[] args) {
        try {
            MiSocketDatagramaServidor servidor = new MiSocketDatagramaServidor(PUERTO);
            System.out.println("Servidor Banco Central iniciado en el puerto " + PUERTO);

            while (true) {
                MensajeDatagrama peticion = servidor.recibeMensajeYEmisor();
                String mensaje = peticion.obtieneMensaje().trim();
                String respuesta = procesarTransaccion(mensaje);

                // Mostrar la transacción recibida en la consola del servidor
                System.out.println("Transaccion procesada: " + mensaje);

                servidor.enviaMensaje(peticion.obtieneDireccion(), peticion.obtienePuerto(), respuesta);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String procesarTransaccion(String mensaje) {
        String[] partes = mensaje.split(":");
        String sucursal = partes[0]; // Identificador de la sucursal
        String tipoTransaccion = partes[1]; // Tipo de transacción
        String detalles = partes[2]; // Detalles adicionales

        // Agregar la transacción al historial de la sucursal
        historialSucursales.putIfAbsent(sucursal, new ArrayList<>());
        historialSucursales.get(sucursal).add(tipoTransaccion + " - " + detalles);

        return "Transaccion recibida: " + tipoTransaccion + " - " + detalles;
    }

    // Método adicional para mostrar el historial global (si es necesario en el futuro)
    public static void mostrarHistorialGlobal() {
        System.out.println("\nHistorial Global de Transacciones:");
        historialSucursales.forEach((sucursal, transacciones) -> {
            System.out.println("Sucursal: " + sucursal);
            transacciones.forEach(System.out::println);
        });
    }
}

