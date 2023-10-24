package entidades;

import java.io.Serializable;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prestamo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Temporal(TemporalType.DATE)
    private Date hasta;
    
    @OneToOne
    private Cliente cliente;
        
    @OneToOne
    private Libro libro;

    public Prestamo() {
    }

    public Prestamo(int id, Date desde, Date hasta, Cliente cliente, Libro libro) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.cliente = cliente;
        this.libro = libro;
    }

    public int getId() {
        return id;
    }

    public Date getPrestamo() {
        return desde;
    }

    public Date getDevolucion() {
        return hasta;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrestamo(Date prestamo) {
        this.desde = prestamo;
    }

    public void setDevolucion(Date devolucion) {
        this.hasta = devolucion;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");   
        return "PRESTAMO\tId:" + id + "\tDESDE:" + dateFormat.format(desde) + "\tHASTA:" + dateFormat.format(hasta) +
                "\n  └>" + libro;
    }  
}