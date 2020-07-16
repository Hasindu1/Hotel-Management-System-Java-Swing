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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "RESITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resitem.findAll", query = "SELECT r FROM Resitem r")
    , @NamedQuery(name = "Resitem.findByItemid", query = "SELECT r FROM Resitem r WHERE r.itemid = :itemid")
    , @NamedQuery(name = "Resitem.findByCategory", query = "SELECT r FROM Resitem r WHERE r.category = :category")
    , @NamedQuery(name = "Resitem.findByItemname", query = "SELECT r FROM Resitem r WHERE r.itemname = :itemname")
    , @NamedQuery(name = "Resitem.findByPrice", query = "SELECT r FROM Resitem r WHERE r.price = :price")
    , @NamedQuery(name = "Resitem.findByQtyonhand", query = "SELECT r FROM Resitem r WHERE r.qtyonhand = :qtyonhand")})
public class Resitem implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEMID")
    private Integer itemid;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "ITEMNAME")
    private String itemname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QTYONHAND")
    private Integer qtyonhand;
    @JoinTable(name = "RESITEM_ORDERS", joinColumns = {
        @JoinColumn(name = "ITEMID", referencedColumnName = "ITEMID")}, inverseJoinColumns = {
        @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")})
    @ManyToMany
    private Collection<Orders> ordersCollection;

    public Resitem() {
    }

    public Resitem(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        Integer oldItemid = this.itemid;
        this.itemid = itemid;
        changeSupport.firePropertyChange("itemid", oldItemid, itemid);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        String oldItemname = this.itemname;
        this.itemname = itemname;
        changeSupport.firePropertyChange("itemname", oldItemname, itemname);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        Double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Integer getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(Integer qtyonhand) {
        Integer oldQtyonhand = this.qtyonhand;
        this.qtyonhand = qtyonhand;
        changeSupport.firePropertyChange("qtyonhand", oldQtyonhand, qtyonhand);
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resitem)) {
            return false;
        }
        Resitem other = (Resitem) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurantManagementFunction.Resitem[ itemid=" + itemid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
