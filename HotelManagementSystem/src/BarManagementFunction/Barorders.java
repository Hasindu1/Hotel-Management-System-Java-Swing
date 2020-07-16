/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarManagementFunction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VAGEE
 */
@Entity
@Table(name = "BARORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barorders.findAll", query = "SELECT b FROM Barorders b")
    , @NamedQuery(name = "Barorders.findById", query = "SELECT b FROM Barorders b WHERE b.id = :id")
    , @NamedQuery(name = "Barorders.findByOrderid", query = "SELECT b FROM Barorders b WHERE b.orderid = :orderid")
    , @NamedQuery(name = "Barorders.findByOrdertype", query = "SELECT b FROM Barorders b WHERE b.ordertype = :ordertype")
    , @NamedQuery(name = "Barorders.findByOrderpid", query = "SELECT b FROM Barorders b WHERE b.orderpid = :orderpid")
    , @NamedQuery(name = "Barorders.findByOrderpname", query = "SELECT b FROM Barorders b WHERE b.orderpname = :orderpname")
    , @NamedQuery(name = "Barorders.findByStunit", query = "SELECT b FROM Barorders b WHERE b.stunit = :stunit")
    , @NamedQuery(name = "Barorders.findByApunit", query = "SELECT b FROM Barorders b WHERE b.apunit = :apunit")
    , @NamedQuery(name = "Barorders.findByPpunit", query = "SELECT b FROM Barorders b WHERE b.ppunit = :ppunit")
    , @NamedQuery(name = "Barorders.findByQuantity", query = "SELECT b FROM Barorders b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "Barorders.findByOrderamount", query = "SELECT b FROM Barorders b WHERE b.orderamount = :orderamount")
    , @NamedQuery(name = "Barorders.findByDate", query = "SELECT b FROM Barorders b WHERE b.date = :date")})
public class Barorders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ORDERID")
    private Integer orderid;
    @Column(name = "ORDERTYPE")
    private String ordertype;
    @Column(name = "ORDERPID")
    private Integer orderpid;
    @Column(name = "ORDERPNAME")
    private String orderpname;
    @Column(name = "STUNIT")
    private String stunit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "APUNIT")
    private Double apunit;
    @Column(name = "PPUNIT")
    private Double ppunit;
    @Column(name = "QUANTITY")
    private Double quantity;
    @Column(name = "ORDERAMOUNT")
    private Double orderamount;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Barorders() {
    }

    public Barorders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        Integer oldOrderid = this.orderid;
        this.orderid = orderid;
        changeSupport.firePropertyChange("orderid", oldOrderid, orderid);
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        String oldOrdertype = this.ordertype;
        this.ordertype = ordertype;
        changeSupport.firePropertyChange("ordertype", oldOrdertype, ordertype);
    }

    public Integer getOrderpid() {
        return orderpid;
    }

    public void setOrderpid(Integer orderpid) {
        Integer oldOrderpid = this.orderpid;
        this.orderpid = orderpid;
        changeSupport.firePropertyChange("orderpid", oldOrderpid, orderpid);
    }

    public String getOrderpname() {
        return orderpname;
    }

    public void setOrderpname(String orderpname) {
        String oldOrderpname = this.orderpname;
        this.orderpname = orderpname;
        changeSupport.firePropertyChange("orderpname", oldOrderpname, orderpname);
    }

    public String getStunit() {
        return stunit;
    }

    public void setStunit(String stunit) {
        String oldStunit = this.stunit;
        this.stunit = stunit;
        changeSupport.firePropertyChange("stunit", oldStunit, stunit);
    }

    public Double getApunit() {
        return apunit;
    }

    public void setApunit(Double apunit) {
        Double oldApunit = this.apunit;
        this.apunit = apunit;
        changeSupport.firePropertyChange("apunit", oldApunit, apunit);
    }

    public Double getPpunit() {
        return ppunit;
    }

    public void setPpunit(Double ppunit) {
        Double oldPpunit = this.ppunit;
        this.ppunit = ppunit;
        changeSupport.firePropertyChange("ppunit", oldPpunit, ppunit);
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        Double oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        Double oldOrderamount = this.orderamount;
        this.orderamount = orderamount;
        changeSupport.firePropertyChange("orderamount", oldOrderamount, orderamount);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
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
        if (!(object instanceof Barorders)) {
            return false;
        }
        Barorders other = (Barorders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarManagementFunction.Barorders[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
