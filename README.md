Proyecto Creado Por Ing. Fabrizio Castro

Componentes Principales:

Cliente Sucursal:
-Permite a las sucursales realizar transacciones como depósitos, retiros y pagos de servicios.
-Envía los mensajes al servidor central y muestra las respuestas.

Servidor Banco Central:
-Recibe las transacciones de las sucursales y procesa la información.
-Mantiene un historial de las transacciones realizadas por cada sucursal.

Comunicación UDP:
-El sistema utiliza DatagramSocket para enviar y recibir mensajes entre las sucursales y el servidor central.

Funcionalidades:
Cliente Sucursal:
-Conectar al servidor para realizar transacciones.
-Opciones de transacción:
-Depositar dinero en una cuenta.
-Retirar dinero de una cuenta.
-Realizar pagos de servicios.
-Ver respuesta del servidor con la confirmación de la transacción.

Servidor Banco Central:
-Recibir transacciones de las sucursales.
-Procesar las transacciones y actualizar el historial.
-Enviar respuestas a las sucursales confirmando las transacciones.

Comunicación UDP:
-Enviar y recibir mensajes utilizando DatagramSocket.
-Transporte eficiente de mensajes entre cliente y servidor sin la necesidad de conexiones persistentes.

Ejemplo de Uso:
-Inicia el servidor central (ServidorCentral).
-Inicia el cliente para una sucursal (ClienteSucursal).
-Realiza una transacción (depósito, retiro o pago de servicio).
-Recibe la respuesta del servidor con el resultado de la transacción.

Notas:
-Asegúrate de que el servidor está en funcionamiento antes de iniciar el cliente.
-Puedes cambiar la dirección y el puerto del servidor según sea necesario.
