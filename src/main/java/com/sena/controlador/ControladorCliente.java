package com.sena.controlador;

import com.sena.dao.ClienteDAO;
import com.sena.modelo.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControladorCliente") 
public class ControladorCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;

    public void init() {
        clienteDAO = new ClienteDAO(); 
    }

    // Maneja peticiones POST (Guardar un nuevo cliente)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Cliente nuevoCliente = new Cliente(nombre, apellido, email, telefono);
        boolean exito = clienteDAO.insertarCliente(nuevoCliente);

        if (exito) {
            // Redirigir al listado para mostrar el nuevo registro y el mensaje de éxito
            response.sendRedirect("ControladorCliente?accion=listar&estado=exito_guardar");
        } else {
            response.sendRedirect("ControladorCliente?accion=listar&estado=error_guardar");
        }
    }

    // Maneja peticiones GET (Mostrar formulario o listar clientes)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        // El RequestDispatcher necesita el path completo a los JSP si no están en la raíz de webapp
        RequestDispatcher dispatcher = null; 
        
        if ("listar".equals(accion)) {
            // Lógica para listar clientes (Cumple requisito GET)
            List<Cliente> listaClientes = clienteDAO.listarClientes();
            
            // Envía la lista al JSP
            request.setAttribute("listaClientes", listaClientes); 
            dispatcher = request.getRequestDispatcher("WEB-INF/lista_clientes.jsp"); // <--- Posible corrección de ruta
            dispatcher.forward(request, response);
            
        } else {
            // Acción por defecto: mostrar el formulario
            dispatcher = request.getRequestDispatcher("WEB-INF/formulario.jsp"); // <--- Posible corrección de ruta
            dispatcher.forward(request, response);
        }
    }
}