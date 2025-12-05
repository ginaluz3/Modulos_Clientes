<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Cliente - Evidencia AA2-EV02</title>
</head>
<body>
    <h1>Registrar Nuevo Cliente</h1>
    
    <% 
        String estado = request.getParameter("estado");
        if ("exito_guardar".equals(estado)) {
            out.println("<p style='color:green;'>✅ Cliente guardado correctamente.</p>");
        } else if ("error_guardar".equals(estado)) {
            out.println("<p style='color:red;'>❌ Error al guardar el cliente.</p>");
        }
    %>

    <form action="ControladorCliente" method="POST"> 
        
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="apellido">Apellido:</label><br>
        <input type="text" id="apellido" name="apellido" required><br><br>
        
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="telefono">Teléfono:</label><br>
        <input type="text" id="telefono" name="telefono"><br><br>
        
        <input type="submit" value="Guardar Cliente">
    </form>
    
    <p><a href="ControladorCliente?accion=listar">Ver Lista de Clientes</a></p>
</body>
</html>