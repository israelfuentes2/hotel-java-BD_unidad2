package conexion.dao;
import conexion.models.Empleado;
import conexion.ConexionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoDAO {
    public static int insertar(Empleado e) throws Exception {
        String sql = "INSERT INTO empleado(nombre,cargo,salario,hotel_id) VALUES (?,?,?,?) RETURNING id";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getNombre()); ps.setString(2, e.getCargo()); ps.setBigDecimal(3, e.getSalario()); 
            if (e.getHotelId() == null) ps.setNull(4, Types.INTEGER); else ps.setInt(4, e.getHotelId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
    public static List<Empleado> listar() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT id,nombre,cargo,salario,hotel_id FROM empleado";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId(rs.getInt(1)); e.setNombre(rs.getString(2)); e.setCargo(rs.getString(3)); e.setSalario(rs.getBigDecimal(4));
                int hid = rs.getInt(5); if (rs.wasNull()) e.setHotelId(null); else e.setHotelId(hid);
                lista.add(e);
            }
        }
        return lista;
    }
    public static boolean actualizar(Empleado e) throws Exception {
        String sql = "UPDATE empleado SET nombre=?, cargo=?, salario=?, hotel_id=? WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getNombre()); ps.setString(2, e.getCargo()); ps.setBigDecimal(3, e.getSalario());
            if (e.getHotelId() == null) ps.setNull(4, Types.INTEGER); else ps.setInt(4, e.getHotelId());
            ps.setInt(5, e.getId());
            return ps.executeUpdate() > 0;
        }
    }
    public static boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM empleado WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
