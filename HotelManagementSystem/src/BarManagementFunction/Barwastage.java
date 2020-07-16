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
@Table(name = "BARWASTAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barwastage.findAll", query = "SELECT b FROM Barwastage b")
    , @NamedQuery(name = "Barwastage.findByWastageid", query = "SELECT b FROM Barwastage b WHERE b.wastageid = :wastageid")
    , @NamedQuery(name = "Barwastage.findByWastageamount", query = "SELECT b FROM Barwastage b WHERE b.wastageamount = :wastageamount")
    , @NamedQuery(name = "Barwastage.findByDate", query = "SELECT b FROM Barwastage b WHERE b.date = :date")})
public class Barwastage implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WASTAGEID")
    private Integer wastageid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WASTAGEAMOUNT")
    private Double wastageamount;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Barwastage() {
    }

    public Barwastage(Integer wastageid) {
        this.wastageid = wastageid;
    }

    public Integer getWastageid() {
        return wastageid;
    }

    public void setWastageid(Integer wastageid) {
        Integer oldWastageid = this.wastageid;
        this.wastageid = wastageid;
        changeSupport.firePropertyChange("wastageid", oldWastageid, wastageid);
    }

    public Double getWastageamount() {
        return wastageamount;
    }

    public void setWastageamount(Double wastageamount) {
        Double oldWastageamount = this.wastageamount;
        this.wastageamount = wastageamount;
        changeSupport.firePropertyChange("wastageamount", oldWastageamount, wastageamount);
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
        hash += (wastageid != null ? wastageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barwastage)) {
            return false;
        }
        Barwastage other = (Barwastage) object;
        if ((this.wastageid == null && other.wastageid != null) || (this.wastageid != null && !this.wastageid.equals(other.wastageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarManagementFunction.Barwastage[ wastageid=" + wastageid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
