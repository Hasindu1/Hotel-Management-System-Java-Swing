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
@Table(name = "BARINCOME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barincome.findAll", query = "SELECT b FROM Barincome b")
    , @NamedQuery(name = "Barincome.findByIncomeid", query = "SELECT b FROM Barincome b WHERE b.incomeid = :incomeid")
    , @NamedQuery(name = "Barincome.findByTotalincome", query = "SELECT b FROM Barincome b WHERE b.totalincome = :totalincome")
    , @NamedQuery(name = "Barincome.findByMonthstartdate", query = "SELECT b FROM Barincome b WHERE b.monthstartdate = :monthstartdate")
    , @NamedQuery(name = "Barincome.findByMonthenddate", query = "SELECT b FROM Barincome b WHERE b.monthenddate = :monthenddate")})
public class Barincome implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INCOMEID")
    private Integer incomeid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALINCOME")
    private Double totalincome;
    @Column(name = "MONTHSTARTDATE")
    @Temporal(TemporalType.DATE)
    private Date monthstartdate;
    @Column(name = "MONTHENDDATE")
    @Temporal(TemporalType.DATE)
    private Date monthenddate;

    public Barincome() {
    }

    public Barincome(Integer incomeid) {
        this.incomeid = incomeid;
    }

    public Integer getIncomeid() {
        return incomeid;
    }

    public void setIncomeid(Integer incomeid) {
        Integer oldIncomeid = this.incomeid;
        this.incomeid = incomeid;
        changeSupport.firePropertyChange("incomeid", oldIncomeid, incomeid);
    }

    public Double getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(Double totalincome) {
        Double oldTotalincome = this.totalincome;
        this.totalincome = totalincome;
        changeSupport.firePropertyChange("totalincome", oldTotalincome, totalincome);
    }

    public Date getMonthstartdate() {
        return monthstartdate;
    }

    public void setMonthstartdate(Date monthstartdate) {
        Date oldMonthstartdate = this.monthstartdate;
        this.monthstartdate = monthstartdate;
        changeSupport.firePropertyChange("monthstartdate", oldMonthstartdate, monthstartdate);
    }

    public Date getMonthenddate() {
        return monthenddate;
    }

    public void setMonthenddate(Date monthenddate) {
        Date oldMonthenddate = this.monthenddate;
        this.monthenddate = monthenddate;
        changeSupport.firePropertyChange("monthenddate", oldMonthenddate, monthenddate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incomeid != null ? incomeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barincome)) {
            return false;
        }
        Barincome other = (Barincome) object;
        if ((this.incomeid == null && other.incomeid != null) || (this.incomeid != null && !this.incomeid.equals(other.incomeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarManagementFunction.Barincome[ incomeid=" + incomeid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
