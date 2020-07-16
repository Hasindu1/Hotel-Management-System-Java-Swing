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
@Table(name = "BARORDERBILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barorderbill.findAll", query = "SELECT b FROM Barorderbill b")
    , @NamedQuery(name = "Barorderbill.findByOrdersid", query = "SELECT b FROM Barorderbill b WHERE b.ordersid = :ordersid")
    , @NamedQuery(name = "Barorderbill.findByCalamount", query = "SELECT b FROM Barorderbill b WHERE b.calamount = :calamount")
    , @NamedQuery(name = "Barorderbill.findByDiscountselect", query = "SELECT b FROM Barorderbill b WHERE b.discountselect = :discountselect")
    , @NamedQuery(name = "Barorderbill.findByDiscount", query = "SELECT b FROM Barorderbill b WHERE b.discount = :discount")
    , @NamedQuery(name = "Barorderbill.findByTotalbill", query = "SELECT b FROM Barorderbill b WHERE b.totalbill = :totalbill")
    , @NamedQuery(name = "Barorderbill.findByStatus", query = "SELECT b FROM Barorderbill b WHERE b.status = :status")
    , @NamedQuery(name = "Barorderbill.findByDate", query = "SELECT b FROM Barorderbill b WHERE b.date = :date")})
public class Barorderbill implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERSID")
    private Integer ordersid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CALAMOUNT")
    private Double calamount;
    @Column(name = "DISCOUNTSELECT")
    private String discountselect;
    @Column(name = "DISCOUNT")
    private Double discount;
    @Column(name = "TOTALBILL")
    private Double totalbill;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Barorderbill() {
    }

    public Barorderbill(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        Integer oldOrdersid = this.ordersid;
        this.ordersid = ordersid;
        changeSupport.firePropertyChange("ordersid", oldOrdersid, ordersid);
    }

    public Double getCalamount() {
        return calamount;
    }

    public void setCalamount(Double calamount) {
        Double oldCalamount = this.calamount;
        this.calamount = calamount;
        changeSupport.firePropertyChange("calamount", oldCalamount, calamount);
    }

    public String getDiscountselect() {
        return discountselect;
    }

    public void setDiscountselect(String discountselect) {
        String oldDiscountselect = this.discountselect;
        this.discountselect = discountselect;
        changeSupport.firePropertyChange("discountselect", oldDiscountselect, discountselect);
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        Double oldDiscount = this.discount;
        this.discount = discount;
        changeSupport.firePropertyChange("discount", oldDiscount, discount);
    }

    public Double getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(Double totalbill) {
        Double oldTotalbill = this.totalbill;
        this.totalbill = totalbill;
        changeSupport.firePropertyChange("totalbill", oldTotalbill, totalbill);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
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
        hash += (ordersid != null ? ordersid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barorderbill)) {
            return false;
        }
        Barorderbill other = (Barorderbill) object;
        if ((this.ordersid == null && other.ordersid != null) || (this.ordersid != null && !this.ordersid.equals(other.ordersid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarManagementFunction.Barorderbill[ ordersid=" + ordersid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
