package conexion;
import conexion.models.*;
import conexion.dao.*;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        try {
            Hotel h = new Hotel("Hotel Sol", "Cartagena", "Calle 1 #2-3");
            int hid = HotelDAO.insertar(h);
            System.out.println("Hotel insertado id="+hid);

            Cliente c = new Cliente("Luis Pérez","luis@example.com","3004567890");
            int cid = ClienteDAO.insertar(c);
            System.out.println("Cliente insertado id="+cid);

            List<Hotel> hoteles = HotelDAO.listar();
            System.out.println("Hoteles en BD:");
            for(Hotel hh: hoteles) System.out.println(hh);

            List<Cliente> clientes = ClienteDAO.listar();
            System.out.println("Clientes en BD:");
            for(Cliente cc: clientes) System.out.println(cc);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
