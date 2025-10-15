package conexion.dao;
import conexion.models.Actividad;
import conexion.ConexionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ActividadDAO {
    public static int insertar(Actividad a) throws Exception {
        String sql = "INSERT INTO actividad(nombre,costo,hotel_id) VALUES (?,?,?) RETURNING id";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNombre()); ps.setBigDecimal(2, a.getCosto()); 
            if (a.getHotelId() == null) ps.setNull(3, Types.INTEGER); else ps.setInt(3, a.getHotelId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
    public static List<Actividad> listar() throws Exception {
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT id,nombre,costo,hotel_id FROM actividad";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Actividad a = new Actividad();
                a.setId(rs.getInt(1)); a.setNombre(rs.getString(2)); a.setCosto(rs.getBigDecimal(3));
                int hid = rs.getInt(4); if (rs.wasNull()) a.setHotelId(null); else a.setHotelId(hid);
                lista.add(a);
            }
        }
        return lista;
    }
    public static boolean actualizar(Actividad a) throws Exception {
        String sql = "UPDATE actividad SET nombre=?, costo=?, hotel_id=? WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNombre()); ps.setBigDecimal(2, a.getCosto());
            if (a.getHotelId() == null) ps.setNull(3, Types.INTEGER); else ps.setInt(3, a.getHotelId());
            ps.setInt(4, a.getId());
            return ps.executeUpdate() > 0;
        }
    }
    public static boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM actividad WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
