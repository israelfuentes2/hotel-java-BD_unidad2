package conexion.models;
import java.math.BigDecimal;
public class Empleado {
    private int id; private String nombre; private String cargo; private BigDecimal salario; private Integer hotelId;
    public Empleado() {}
    public Empleado(String nombre,String cargo,BigDecimal salario,Integer hotelId){this.nombre=nombre;this.cargo=cargo;this.salario=salario;this.hotelId=hotelId;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
    public String getCargo(){return cargo;} public void setCargo(String cargo){this.cargo=cargo;}
    public BigDecimal getSalario(){return salario;} public void setSalario(BigDecimal salario){this.salario=salario;}
    public Integer getHotelId(){return hotelId;} public void setHotelId(Integer hotelId){this.hotelId=hotelId;}
    @Override public String toString(){ return id+" - "+nombre+" ("+cargo+")"; }
}
