package conexion.dao;

import conexion.ConexionPostgres;
import conexion.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static int insertar(Cliente c) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cliente (nombre, correo, telefono) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getTelefono());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("id");
        }
        return 0;
    }

    public static List<Cliente> listar() throws SQLException, ClassNotFoundException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConexionPostgres.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono")
                );
                lista.add(c);
            }
        }
        return lista;
    }

    public static boolean actualizar(Cliente c) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cliente SET nombre=?, correo=?, telefono=? WHERE id=?";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public static boolean eliminar(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM cliente WHERE id=?";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
