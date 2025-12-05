package com.sena.dao;

import com.sena.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // URL AJUSTADA: Conexión al puerto 3307
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/db_proyecto_sena?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final String INSERTAR_SQL = "INSERT INTO clientes (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String LISTAR_SQL = "SELECT * FROM clientes";

    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
            throw new SQLException("Error de configuración del driver.");
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // Método POST
    public boolean insertarCliente(Cliente cliente) {
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(INSERTAR_SQL)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método GET
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(LISTAR_SQL); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), 
                    rs.getString("email"), rs.getString("telefono")
                );
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return listaClientes;
    }
}