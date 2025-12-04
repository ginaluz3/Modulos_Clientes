# 📌 Módulo de Gestión de Clientes  

Proyecto SENA – GA7-220501096-AA2-EV02  

CRUD con Java, JSP, Servlets, JDBC y MySQL  

Autor: **Luis Morelos B.**
 
---

## 📘 Descripción del Proyecto
 
Este proyecto implementa un **sistema de gestión de clientes** usando la arquitectura **MVC** en Java.  

El sistema permite:

* Registrar clientes

* Listar clientes

* Editar clientes

* Eliminar clientes  
 
Las vistas se manejan con **JSP**, la lógica con **Servlets**, y la persistencia con **JDBC** utilizando **MySQL** como base de datos.
 
---

## 🧱 Arquitectura (MVC)
 
**Modelo**

* `Cliente.java`

* `ClienteDAO.java`

* `Conexion.java`
 
**Vista (JSP)**

* `index.jsp`

* `lista_clientes.jsp`

* `formulario.jsp`
 
**Controlador**

* `ControladorCliente.java`
 
---

## 🗂️ Estructura del Proyecto
 
modulo_clientes/

│

├── src/main/java/com/sena/

│ ├── controlador/

│ │ └── ControladorCliente.java

│ ├── dao/

│ │ └── ClienteDAO.java

│ └── modelo/

│ └── Cliente.java

│

├── src/main/webapp/

│ ├── index.jsp

│ ├── lista_clientes.jsp

│ └── formulario.jsp

│

├── pom.xml

└── README.md
 
---

## 🛢️ Base de Datos
 
### Crear la BD:
 
```sql

CREATE DATABASE modulo_clientes_db;

USE modulo_clientes_db;
 
CREATE TABLE clientes (

  id INT AUTO_INCREMENT PRIMARY KEY,

  nombre VARCHAR(100),

  correo VARCHAR(100),

  telefono VARCHAR(20)

);
 
### 🔑 Configuración de Conexión
 
Antes de ejecutar, asegúrate de configurar los parámetros de conexión a tu base de datos MySQL en el archivo `src/main/java/com/sena/dao/Conexion.java`:
 
```java

// Cambia 'root' y 'TU_PASSWORD' según tu configuración local de MySQL

private static final String URL = "jdbc:mysql://localhost:3306/modulo_clientes_db?useSSL=false&serverTimezone=UTC";

private static final String USER = "root"; 

private static final String PASS = "TU_PASSWORD"; // <--- ¡Modificar!
 
---
 
### 2. Secciones para Pruebas y Contribuciones
 
Estas secciones son esenciales para indicar que el proyecto está listo para ser probado y, si aplica, cómo otros pueden participar.
 
> **📌 Sección a Agregar:** **Instrucciones para Pruebas**
 
```markdown

## 🧪 Pruebas y Verificación (CRUD)
 
Para verificar el funcionamiento correcto del sistema, accede a la URL principal y prueba las siguientes operaciones:
 
1.  **C** (Create/Registrar): Usa el formulario para agregar un nuevo cliente.

2.  **R** (Read/Listar): Confirma que el nuevo cliente aparece en `lista_clientes.jsp`.

3.  **U** (Update/Editar): Usa el botón "Editar" junto a un registro para modificar sus datos.

4.  **D** (Delete/Eliminar): Usa el botón "Eliminar" para borrar un cliente de la base de datos.
 
## 🖼️ Diagrama de Flujo (MVC)
 
El sistema sigue un flujo estricto de **Modelo-Vista-Controlador** para manejar las peticiones del usuario:
 
1.  **Usuario** envía una solicitud (navegar, registrar) al **Controlador** (`ControladorCliente.java`).

2.  El **Controlador** interactúa con el **Modelo** (`ClienteDAO.java`) para acceder a la base de datos.

3.  El **Modelo** devuelve los datos al **Controlador**.

4.  El **Controlador** selecciona la **Vista** (JSP) adecuada para renderizar la respuesta.

5.  La **Vista** se envía de vuelta al **Usuario**.

 
