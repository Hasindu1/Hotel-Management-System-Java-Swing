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
@Table(name = "BARSTOCKCONTROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barstockcontrol.findAll", query = "SELECT b FROM Barstockcontrol b")
    , @NamedQuery(name = "Barstockcontrol.findByProductid", query = "SELECT b FROM Barstockcontrol b WHERE b.productid = :productid")
    , @NamedQuery(name = "Barstockcontrol.findByProductname", query = "SELECT b FROM Barstockcontrol b WHERE b.productname = :productname")
    , @NamedQuery(name = "Barstockcontrol.findByStandardunit", query = "SELECT b FROM Barstockcontrol b WHERE b.standardunit = :standardunit")
    , @NamedQuery(name = "Barstockcontrol.findByAmountperunit", query = "SELECT b FROM Barstockcontrol b WHERE b.amountperunit = :amountperunit")
    , @NamedQuery(name = "Barstockcontrol.findByPriceperunit", query = "SELECT b FROM Barstockcontrol b WHERE b.priceperunit = :priceperunit")
    , @NamedQuery(name = "Barstockcontrol.findByDate", query = "SELECT b FROM Barstockcontrol b WHERE b.date = :date")})
public class Barstockcontrol implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Column(name = "STANDARDUNIT")
    private String standardunit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNTPERUNIT")
    private Double amountperunit;
    @Column(name = "PRICEPERUNIT")
    private Double priceperunit;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Barstockcontrol() {
    }

    public Barstockcontrol(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        Integer oldProductid = this.productid;
        this.productid = productid;
        changeSupport.firePropertyChange("productid", oldProductid, productid);
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        String oldProductname = this.productname;
        this.productname = productname;
        changeSupport.firePropertyChange("productname", oldProductname, productname);
    }

    public String getStandardunit() {
        return standardunit;
    }

    public void setStandardunit(String standardunit) {
        String oldStandardunit = this.standardunit;
        this.standardunit = standardunit;
        changeSupport.firePropertyChange("standardunit", oldStandardunit, standardunit);
    }

    public Double getAmountperunit() {
        return amountperunit;
    }

    public void setAmountperunit(Double amountperunit) {
        Double oldAmountperunit = this.amountperunit;
        this.amountperunit = amountperunit;
        changeSupport.firePropertyChange("amountperunit", oldAmountperunit, amountperunit);
    }

    public Double getPriceperunit() {
        return priceperunit;
    }

    public void setPriceperunit(Double priceperunit) {
        Double oldPriceperunit = this.priceperunit;
        this.priceperunit = priceperunit;
        changeSupport.firePropertyChange("priceperunit", oldPriceperunit, priceperunit);
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
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barstockcontrol)) {
            return false;
        }
        Barstockcontrol other = (Barstockcontrol) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarManagementFunction.Barstockcontrol[ productid=" + productid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
