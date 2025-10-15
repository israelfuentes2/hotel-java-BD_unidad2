package conexion.dao;
import conexion.models.Factura;
import conexion.ConexionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FacturaDAO {
    public static int insertar(Factura f) throws Exception {
        String sql = "INSERT INTO factura(cliente_id,reserva_id,fecha,total) VALUES (?,?,?,?) RETURNING id";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, f.getClienteId()); 
            if (f.getReservaId() == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, f.getReservaId());
            ps.setDate(3, Date.valueOf(f.getFecha())); ps.setBigDecimal(4, f.getTotal());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
    public static List<Factura> listar() throws Exception {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT id,cliente_id,reserva_id,fecha,total FROM factura";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Factura f = new Factura();
                f.setId(rs.getInt(1)); f.setClienteId(rs.getInt(2));
                int rid = rs.getInt(3); if (rs.wasNull()) f.setReservaId(null); else f.setReservaId(rid);
                f.setFecha(rs.getDate(4).toLocalDate()); f.setTotal(rs.getBigDecimal(5));
                lista.add(f);
            }
        }
        return lista;
    }
    public static boolean actualizar(Factura f) throws Exception {
        String sql = "UPDATE factura SET cliente_id=?, reserva_id=?, fecha=?, total=? WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, f.getClienteId());
            if (f.getReservaId() == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, f.getReservaId());
            ps.setDate(3, Date.valueOf(f.getFecha())); ps.setBigDecimal(4, f.getTotal()); ps.setInt(5, f.getId());
            return ps.executeUpdate() > 0;
        }
    }
    public static boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM factura WHERE id=?";
        try (Connection c = ConexionPostgres.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
