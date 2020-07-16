/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierManagement;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaushalya
 */
@Entity
@Table(name = "ORDERDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o")
    , @NamedQuery(name = "Orderdetails.findByOrderid", query = "SELECT o FROM Orderdetails o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orderdetails.findByOrderdate", query = "SELECT o FROM Orderdetails o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orderdetails.findByQuantity", query = "SELECT o FROM Orderdetails o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "Orderdetails.findByUnitprice", query = "SELECT o FROM Orderdetails o WHERE o.unitprice = :unitprice")
    , @NamedQuery(name = "Orderdetails.findByTotal", query = "SELECT o FROM Orderdetails o WHERE o.total = :total")})
public class Orderdetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "QUANTITY")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNITPRICE")
    private Double unitprice;
    @Column(name = "TOTAL")
    private Double total;
    @JoinColumn(name = "SUPPLIERID", referencedColumnName = "SUPPLIERID")
    @ManyToOne
    private Supplierdetails supplierid;
    @JoinColumn(name = "ITEMCODE", referencedColumnName = "ITEMCODE")
    @ManyToOne
    private Supplieritems itemcode;

    public Orderdetails() {
    }

    public Orderdetails(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        Integer oldOrderid = this.orderid;
        this.orderid = orderid;
        changeSupport.firePropertyChange("orderid", oldOrderid, orderid);
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        Date oldOrderdate = this.orderdate;
        this.orderdate = orderdate;
        changeSupport.firePropertyChange("orderdate", oldOrderdate, orderdate);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        Double oldUnitprice = this.unitprice;
        this.unitprice = unitprice;
        changeSupport.firePropertyChange("unitprice", oldUnitprice, unitprice);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        Double oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public Supplierdetails getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Supplierdetails supplierid) {
        Supplierdetails oldSupplierid = this.supplierid;
        this.supplierid = supplierid;
        changeSupport.firePropertyChange("supplierid", oldSupplierid, supplierid);
    }

    public Supplieritems getItemcode() {
        return itemcode;
    }

    public void setItemcode(Supplieritems itemcode) {
        Supplieritems oldItemcode = this.itemcode;
        this.itemcode = itemcode;
        changeSupport.firePropertyChange("itemcode", oldItemcode, itemcode);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supplierManagement.Orderdetails[ orderid=" + orderid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
