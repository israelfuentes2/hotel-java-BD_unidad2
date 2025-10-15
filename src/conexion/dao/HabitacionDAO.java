package conexion.dao;
import conexion.models.Habitacion;
import conexion.ConexionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class HabitacionDAO {
    public static int insertar(Habitacion h) throws Exception {
        String sql = "INSERT INTO habitacion(numero,tipo,precio,hotel_id) VALUES (?,?,?,?) RETURNING id";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, h.getNumero()); ps.setString(2, h.getTipo()); ps.setBigDecimal(3, h.getPrecio()); ps.setInt(4, h.getHotelId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
    public static List<Habitacion> listar() throws Exception {
        List<Habitacion> lista = new ArrayList<>();
        String sql = "SELECT id,numero,tipo,precio,hotel_id FROM habitacion";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setId(rs.getInt(1)); h.setNumero(rs.getInt(2)); h.setTipo(rs.getString(3)); h.setPrecio(rs.getBigDecimal(4)); h.setHotelId(rs.getInt(5));
                lista.add(h);
            }
        }
        return lista;
    }
    public static boolean actualizar(Habitacion h) throws Exception {
        String sql = "UPDATE habitacion SET numero=?, tipo=?, precio=?, hotel_id=? WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, h.getNumero()); ps.setString(2, h.getTipo()); ps.setBigDecimal(3, h.getPrecio()); ps.setInt(4, h.getHotelId()); ps.setInt(5, h.getId());
            return ps.executeUpdate() > 0;
        }
    }
    public static boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM habitacion WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
