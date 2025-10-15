package conexion.models;
import java.time.LocalDate;
public class Reserva {
    private int id; private int clienteId; private int hotelId; private int habitacionId;
    private LocalDate fechaInicio; private LocalDate fechaFin;
    public Reserva() {}
    public Reserva(int clienteId,int hotelId,int habitacionId,LocalDate fechaInicio,LocalDate fechaFin){
        this.clienteId=clienteId;this.hotelId=hotelId;this.habitacionId=habitacionId;this.fechaInicio=fechaInicio;this.fechaFin=fechaFin;
    }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getClienteId(){return clienteId;} public void setClienteId(int clienteId){this.clienteId=clienteId;}
    public int getHotelId(){return hotelId;} public void setHotelId(int hotelId){this.hotelId=hotelId;}
    public int getHabitacionId(){return habitacionId;} public void setHabitacionId(int habitacionId){this.habitacionId=habitacionId;}
    public LocalDate getFechaInicio(){return fechaInicio;} public void setFechaInicio(LocalDate fechaInicio){this.fechaInicio=fechaInicio;}
    public LocalDate getFechaFin(){return fechaFin;} public void setFechaFin(LocalDate fechaFin){this.fechaFin=fechaFin;}
    @Override public String toString(){ return id+" -> cliente:"+clienteId+" habitacion:"+habitacionId+" desde:"+fechaInicio; }
}
