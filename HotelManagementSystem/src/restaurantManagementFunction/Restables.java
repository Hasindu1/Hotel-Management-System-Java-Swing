/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "RESTABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restables.findAll", query = "SELECT r FROM Restables r")
    , @NamedQuery(name = "Restables.findByRestableid", query = "SELECT r FROM Restables r WHERE r.restableid = :restableid")
    , @NamedQuery(name = "Restables.findByTableno", query = "SELECT r FROM Restables r WHERE r.tableno = :tableno")
    , @NamedQuery(name = "Restables.findByCapacity", query = "SELECT r FROM Restables r WHERE r.capacity = :capacity")})
public class Restables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESTABLEID")
    private Integer restableid;
    @Column(name = "TABLENO")
    private Integer tableno;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @OneToMany(mappedBy = "restableid")
    private Collection<Bookedtable> bookedtableCollection;

    public Restables() {
    }

    public Restables(Integer restableid) {
        this.restableid = restableid;
    }

    public Integer getRestableid() {
        return restableid;
    }

    public void setRestableid(Integer restableid) {
        this.restableid = restableid;
    }

    public Integer getTableno() {
        return tableno;
    }

    public void setTableno(Integer tableno) {
        this.tableno = tableno;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Collection<Bookedtable> getBookedtableCollection() {
        return bookedtableCollection;
    }

    public void setBookedtableCollection(Collection<Bookedtable> bookedtableCollection) {
        this.bookedtableCollection = bookedtableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restableid != null ? restableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restables)) {
            return false;
        }
        Restables other = (Restables) object;
        if ((this.restableid == null && other.restableid != null) || (this.restableid != null && !this.restableid.equals(other.restableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurantManagementFunction.Restables[ restableid=" + restableid + " ]";
    }
    
}
