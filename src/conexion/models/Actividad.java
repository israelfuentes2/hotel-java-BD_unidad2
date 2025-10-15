package conexion.models;
import java.math.BigDecimal;
public class Actividad {
    private int id; private String nombre; private BigDecimal costo; private Integer hotelId;
    public Actividad() {}
    public Actividad(String nombre,BigDecimal costo,Integer hotelId){this.nombre=nombre;this.costo=costo;this.hotelId=hotelId;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
    public BigDecimal getCosto(){return costo;} public void setCosto(BigDecimal costo){this.costo=costo;}
    public Integer getHotelId(){return hotelId;} public void setHotelId(Integer hotelId){this.hotelId=hotelId;}
    @Override public String toString(){ return id+" - "+nombre+" -> "+costo; }
}
