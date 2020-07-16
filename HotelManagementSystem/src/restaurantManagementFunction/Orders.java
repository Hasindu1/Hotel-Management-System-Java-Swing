/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total")
    , @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orders.findByHandledstatus", query = "SELECT o FROM Orders o WHERE o.handledstatus = :handledstatus")
    , @NamedQuery(name = "Orders.findByHandleddate", query = "SELECT o FROM Orders o WHERE o.handleddate = :handleddate")})
public class Orders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "HANDLEDSTATUS")
    private Boolean handledstatus;
    @Column(name = "HANDLEDDATE")
    @Temporal(TemporalType.DATE)
    private Date handleddate;
    @ManyToMany(mappedBy = "ordersCollection")
    private Collection<Resitem> resitemCollection;
    @JoinColumn(name = "GUESTID", referencedColumnName = "GUESTID")
    @ManyToOne
    private Restaurantuser guestid;
    @OneToMany(mappedBy = "orderid")
    private Collection<Bookedtable> bookedtableCollection;

    public Orders() {
    }

    public Orders(Integer orderid) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        Double oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        Date oldOrderdate = this.orderdate;
        this.orderdate = orderdate;
        changeSupport.firePropertyChange("orderdate", oldOrderdate, orderdate);
    }

    public Boolean getHandledstatus() {
        return handledstatus;
    }

    public void setHandledstatus(Boolean handledstatus) {
        Boolean oldHandledstatus = this.handledstatus;
        this.handledstatus = handledstatus;
        changeSupport.firePropertyChange("handledstatus", oldHandledstatus, handledstatus);
    }

    public Date getHandleddate() {
        return handleddate;
    }

    public void setHandleddate(Date handleddate) {
        Date oldHandleddate = this.handleddate;
        this.handleddate = handleddate;
        changeSupport.firePropertyChange("handleddate", oldHandleddate, handleddate);
    }

    @XmlTransient
    public Collection<Resitem> getResitemCollection() {
        return resitemCollection;
    }

    public void setResitemCollection(Collection<Resitem> resitemCollection) {
        this.resitemCollection = resitemCollection;
    }

    public Restaurantuser getGuestid() {
        return guestid;
    }

    public void setGuestid(Restaurantuser guestid) {
        Restaurantuser oldGuestid = this.guestid;
        this.guestid = guestid;
        changeSupport.firePropertyChange("guestid", oldGuestid, guestid);
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
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurantManagementFunction.Orders[ orderid=" + orderid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
