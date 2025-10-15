package conexion.models;
import java.math.BigDecimal;
public class Habitacion {
    private int id; private int numero; private String tipo; private BigDecimal precio; private int hotelId;
    public Habitacion() {}
    public Habitacion(int numero,String tipo,BigDecimal precio,int hotelId){this.numero=numero;this.tipo=tipo;this.precio=precio;this.hotelId=hotelId;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getNumero(){return numero;} public void setNumero(int numero){this.numero=numero;}
    public String getTipo(){return tipo;} public void setTipo(String tipo){this.tipo=tipo;}
    public BigDecimal getPrecio(){return precio;} public void setPrecio(BigDecimal precio){this.precio=precio;}
    public int getHotelId(){return hotelId;} public void setHotelId(int hotelId){this.hotelId=hotelId;}
    @Override public String toString(){ return id+" - "+tipo+" #"+numero+" -> "+precio; }
}
