package SistemaGestranbanCliente-Servidor;

import java.io.*;

public class ClienteSucursal {
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Sucursal Banco Central");
            System.out.println("Ingrese la direccion del servidor:");
            String direccionServidor = entrada.readLine();
            if (direccionServidor.isEmpty()) {
                direccionServidor = "localhost";
            }

            System.out.println("Ingrese el puerto del servidor:");
            String puerto = entrada.readLine();
            if (puerto.isEmpty()) {
                puerto = "6000";
            }

            System.out.println("Ingrese el nombre de esta sucursal:");
            String sucursal = entrada.readLine();

            while (true) {
                System.out.println("\nOpciones de transaccion:");
                System.out.println("1. Deposito");
                System.out.println("2. Retiro");
                System.out.println("3. Pago de servicio");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                String opcion = entrada.readLine();

                if (opcion.equals("4")) {
                    System.out.println("Cerrando conexion...");
                    break;
                }

                String tipoTransaccion = "";
                if (opcion.equals("1")) {
                    tipoTransaccion = "Deposito";
                } else if (opcion.equals("2")) {
                    tipoTransaccion = "Retiro";
                } else if (opcion.equals("3")) {
                    tipoTransaccion = "PagoServicio";
                } else {
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    continue; // Regresa al inicio del bucle
                }

                System.out.print("Ingrese el numero de cuenta: ");
                String cuenta = entrada.readLine();

                System.out.print("Ingrese el monto: ");
                String monto = entrada.readLine();

                // Formato del mensaje: Sucursal:TipoTransaccion:Detalles
                String mensaje = sucursal + ":" + tipoTransaccion + ":" + "Cuenta " + cuenta + ", Monto " + monto;

                // Enviar el mensaje al servidor y mostrar la respuesta
                String respuesta = ClienteAuxiliar.enviarComando(direccionServidor, puerto, mensaje);
                System.out.println("Respuesta del servidor: " + respuesta);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

