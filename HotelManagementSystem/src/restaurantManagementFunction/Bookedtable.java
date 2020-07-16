/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "BOOKEDTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookedtable.findAll", query = "SELECT b FROM Bookedtable b")
    , @NamedQuery(name = "Bookedtable.findByBookedtableid", query = "SELECT b FROM Bookedtable b WHERE b.bookedtableid = :bookedtableid")
    , @NamedQuery(name = "Bookedtable.findByBookeddatetime", query = "SELECT b FROM Bookedtable b WHERE b.bookeddatetime = :bookeddatetime")})
public class Bookedtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKEDTABLEID")
    private Integer bookedtableid;
    @Column(name = "BOOKEDDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookeddatetime;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
    @ManyToOne
    private Orders orderid;
    @JoinColumn(name = "RESTABLEID", referencedColumnName = "RESTABLEID")
    @ManyToOne
    private Restables restableid;

    public Bookedtable() {
    }

    public Bookedtable(Integer bookedtableid) {
        this.bookedtableid = bookedtableid;
    }

    public Integer getBookedtableid() {
        return bookedtableid;
    }

    public void setBookedtableid(Integer bookedtableid) {
        this.bookedtableid = bookedtableid;
    }

    public Date getBookeddatetime() {
        return bookeddatetime;
    }

    public void setBookeddatetime(Date bookeddatetime) {
        this.bookeddatetime = bookeddatetime;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    public Restables getRestableid() {
        return restableid;
    }

    public void setRestableid(Restables restableid) {
        this.restableid = restableid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookedtableid != null ? bookedtableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookedtable)) {
            return false;
        }
        Bookedtable other = (Bookedtable) object;
        if ((this.bookedtableid == null && other.bookedtableid != null) || (this.bookedtableid != null && !this.bookedtableid.equals(other.bookedtableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurantManagementFunction.Bookedtable[ bookedtableid=" + bookedtableid + " ]";
    }
    
}
