package conexion.models;
import java.math.BigDecimal;
import java.time.LocalDate;
public class Factura {
    private int id; private int clienteId; private Integer reservaId; private LocalDate fecha; private BigDecimal total;
    public Factura() {}
    public Factura(int clienteId,Integer reservaId,LocalDate fecha,BigDecimal total){this.clienteId=clienteId;this.reservaId=reservaId;this.fecha=fecha;this.total=total;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getClienteId(){return clienteId;} public void setClienteId(int clienteId){this.clienteId=clienteId;}
    public Integer getReservaId(){return reservaId;} public void setReservaId(Integer reservaId){this.reservaId=reservaId;}
    public LocalDate getFecha(){return fecha;} public void setFecha(LocalDate fecha){this.fecha=fecha;}
    public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal total){this.total=total;}
    @Override public String toString(){ return id+" - total:"+total+" fecha:"+fecha; }
}
