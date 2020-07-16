/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

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
 * @author Vishu PC
 */
@Entity
@Table(name = "SUPPLIERITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplieritems.findAll", query = "SELECT s FROM Supplieritems s")
    , @NamedQuery(name = "Supplieritems.findByItemcode", query = "SELECT s FROM Supplieritems s WHERE s.itemcode = :itemcode")
    , @NamedQuery(name = "Supplieritems.findByName", query = "SELECT s FROM Supplieritems s WHERE s.name = :name")
    , @NamedQuery(name = "Supplieritems.findByMonth", query = "SELECT s FROM Supplieritems s WHERE s.month = :month")
    , @NamedQuery(name = "Supplieritems.findByQty", query = "SELECT s FROM Supplieritems s WHERE s.qty = :qty")
    , @NamedQuery(name = "Supplieritems.findByDailyusage", query = "SELECT s FROM Supplieritems s WHERE s.dailyusage = :dailyusage")
    , @NamedQuery(name = "Supplieritems.findByGrn", query = "SELECT s FROM Supplieritems s WHERE s.grn = :grn")
    , @NamedQuery(name = "Supplieritems.findByVarience", query = "SELECT s FROM Supplieritems s WHERE s.varience = :varience")
    , @NamedQuery(name = "Supplieritems.findByMonthendcount", query = "SELECT s FROM Supplieritems s WHERE s.monthendcount = :monthendcount")
    , @NamedQuery(name = "Supplieritems.findByWastage", query = "SELECT s FROM Supplieritems s WHERE s.wastage = :wastage")})
public class Supplieritems implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ITEMCODE")
    private String itemcode;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MONTH")
    @Temporal(TemporalType.DATE)
    private Date month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "DAILYUSAGE")
    private Double dailyusage;
    @Column(name = "GRN")
    private Double grn;
    @Column(name = "VARIENCE")
    private Double varience;
    @Column(name = "MONTHENDCOUNT")
    private Double monthendcount;
    @Column(name = "WASTAGE")
    private Double wastage;

    public Supplieritems() {
    }

    public Supplieritems(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        String oldItemcode = this.itemcode;
        this.itemcode = itemcode;
        changeSupport.firePropertyChange("itemcode", oldItemcode, itemcode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        Date oldMonth = this.month;
        this.month = month;
        changeSupport.firePropertyChange("month", oldMonth, month);
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        Double oldQty = this.qty;
        this.qty = qty;
        changeSupport.firePropertyChange("qty", oldQty, qty);
    }

    public Double getDailyusage() {
        return dailyusage;
    }

    public void setDailyusage(Double dailyusage) {
        Double oldDailyusage = this.dailyusage;
        this.dailyusage = dailyusage;
        changeSupport.firePropertyChange("dailyusage", oldDailyusage, dailyusage);
    }

    public Double getGrn() {
        return grn;
    }

    public void setGrn(Double grn) {
        Double oldGrn = this.grn;
        this.grn = grn;
        changeSupport.firePropertyChange("grn", oldGrn, grn);
    }

    public Double getVarience() {
        return varience;
    }

    public void setVarience(Double varience) {
        Double oldVarience = this.varience;
        this.varience = varience;
        changeSupport.firePropertyChange("varience", oldVarience, varience);
    }

    public Double getMonthendcount() {
        return monthendcount;
    }

    public void setMonthendcount(Double monthendcount) {
        Double oldMonthendcount = this.monthendcount;
        this.monthendcount = monthendcount;
        changeSupport.firePropertyChange("monthendcount", oldMonthendcount, monthendcount);
    }

    public Double getWastage() {
        return wastage;
    }

    public void setWastage(Double wastage) {
        Double oldWastage = this.wastage;
        this.wastage = wastage;
        changeSupport.firePropertyChange("wastage", oldWastage, wastage);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemcode != null ? itemcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplieritems)) {
            return false;
        }
        Supplieritems other = (Supplieritems) object;
        if ((this.itemcode == null && other.itemcode != null) || (this.itemcode != null && !this.itemcode.equals(other.itemcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventory.Supplieritems[ itemcode=" + itemcode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
