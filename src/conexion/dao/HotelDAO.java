package conexion.dao;

import conexion.ConexionPostgres;
import conexion.models.Hotel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public static int insertar(Hotel h) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO hotel (nombre, ciudad, direccion) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, h.getNombre());
            ps.setString(2, h.getCiudad());
            ps.setString(3, h.getDireccion());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("id");
        }
        return 0;
    }

    public static List<Hotel> listar() throws SQLException, ClassNotFoundException {
        List<Hotel> lista = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection conn = ConexionPostgres.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Hotel h = new Hotel(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("ciudad"),
                    rs.getString("direccion")
                );
                lista.add(h);
            }
        }
        return lista;
    }

    public static boolean actualizar(Hotel h) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE hotel SET nombre=?, ciudad=?, direccion=? WHERE id=?";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, h.getNombre());
            ps.setString(2, h.getCiudad());
            ps.setString(3, h.getDireccion());
            ps.setInt(4, h.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public static boolean eliminar(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM hotel WHERE id=?";
        try (Connection conn = ConexionPostgres.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
