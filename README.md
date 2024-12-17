# Sistema de Banco Central con Comunicación por Datagramas (UDP)

## Descripción
**Proyecto Creado Por:** Ing. Fabrizio Castro

Este proyecto implementa un sistema bancario simple donde varias **sucursales** se comunican con un **servidor central** utilizando comunicación por datagramas (UDP). Las sucursales pueden realizar **depósitos**, **retiros** y **pagos de servicios**, mientras que el servidor procesa estas transacciones y mantiene un historial por sucursal.

---

## Componentes Principales

### **Cliente Sucursal**
- Permite a las sucursales realizar transacciones como:
  - Depósitos
  - Retiros
  - Pagos de servicios
- Envía los mensajes al servidor central y muestra las respuestas recibidas.

### **Servidor Banco Central**
- Recibe las transacciones enviadas por las sucursales.
- Procesa y actualiza el historial de transacciones por cada sucursal.
- Envía respuestas confirmando el resultado de cada transacción.

### **Comunicación UDP**
- Utiliza `DatagramSocket` para enviar y recibir mensajes entre el cliente (sucursal) y el servidor central.
- Transporte eficiente de mensajes sin necesidad de conexiones persistentes.

---

## Funcionalidades

### **Cliente Sucursal**
1. **Conectar al servidor:**  
   Permite establecer conexión con el servidor central especificando la dirección y el puerto.
2. **Opciones de Transacción:**
   - **Depositar dinero:** Registrar depósitos en una cuenta.
   - **Retirar dinero:** Realizar retiros de una cuenta.
   - **Pago de servicios:** Registrar pagos realizados.
3. **Visualizar Respuestas:**
   - Muestra la respuesta del servidor confirmando el resultado de cada transacción.

### **Servidor Banco Central**
1. **Recepción de Transacciones:**  
   Recibe las transacciones enviadas por las sucursales.
2. **Procesamiento de Transacciones:**  
   Actualiza el historial y procesa los datos de manera eficiente.
3. **Confirmación de Respuestas:**  
   Envía respuestas a las sucursales indicando el resultado de las operaciones.

### **Comunicación UDP**
- Enviar y recibir mensajes utilizando `DatagramSocket`.
- Proporciona un transporte ligero y eficiente de los mensajes entre cliente y servidor.

---

## Ejemplo de Uso

1. **Inicia el Servidor Central:**  
   Ejecuta el archivo `ServidorCentral` para levantar el servidor central:
   ```bash
   java SistemaBanco.ServidorCentral
