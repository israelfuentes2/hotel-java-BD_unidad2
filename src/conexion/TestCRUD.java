package conexion;
import conexion.models.*;
import conexion.dao.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestCRUD {
    public static void main(String[] args) {
        try {
            System.out.println("=== TEST CRUD HABITACION ===");
            Habitacion h = new Habitacion(201, "Doble", new BigDecimal("250000"), 1);
            int hid = HabitacionDAO.insertar(h);
            System.out.println("Habitacion insertada id="+hid);

            List<Habitacion> habs = HabitacionDAO.listar();
            for(Habitacion hh: habs) System.out.println(hh);

            System.out.println("=== TEST CRUD EMPLEADO ===");
            Empleado e = new Empleado("Jose Perez","Recepcion", new BigDecimal("1500000"), 1);
            int eid = EmpleadoDAO.insertar(e);
            System.out.println("Empleado insertado id="+eid);
            List<Empleado> emps = EmpleadoDAO.listar();
            for(Empleado ee: emps) System.out.println(ee);

            System.out.println("=== TEST CRUD ACTIVIDAD ===");
            Actividad a = new Actividad("Tour Playa", new BigDecimal("120000"), 1);
            int aid = ActividadDAO.insertar(a);
            System.out.println("Actividad insertada id="+aid);
            List<Actividad> acts = ActividadDAO.listar();
            for(Actividad aa: acts) System.out.println(aa);

            System.out.println("=== TEST CRUD FACTURA ===");
            Factura f = new Factura(1, null, LocalDate.now(), new BigDecimal("500000"));
            int fid = FacturaDAO.insertar(f);
            System.out.println("Factura insertada id="+fid);
            List<Factura> facs = FacturaDAO.listar();
            for(Factura ff: facs) System.out.println(ff);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
