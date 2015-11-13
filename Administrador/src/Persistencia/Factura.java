/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Mati
 */
@Entity
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int IdReserva;
    private Date FechaGenerada;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Collection<Linea> lineas;
    private int total;
    private String nickCliente;

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public Date getFechaGenerada() {
        return FechaGenerada;
    }

    public void setFechaGenerada(Date FechaGenerada) {
        this.FechaGenerada = FechaGenerada;
    }

    public Collection<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(Collection<Linea> lineas) {
        this.lineas = lineas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNickCliente() {
        return nickCliente;
    }

    public void setNickCliente(String nickCliente) {
        this.nickCliente = nickCliente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Factura[ id=" + id + " ]";
    }
    
}
