/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierManagement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaushalya
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
    @OneToMany(mappedBy = "itemcode")
    private Collection<Orderdetails> orderdetailsCollection;

    public Supplieritems() {
    }

    public Supplieritems(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getDailyusage() {
        return dailyusage;
    }

    public void setDailyusage(Double dailyusage) {
        this.dailyusage = dailyusage;
    }

    public Double getGrn() {
        return grn;
    }

    public void setGrn(Double grn) {
        this.grn = grn;
    }

    public Double getVarience() {
        return varience;
    }

    public void setVarience(Double varience) {
        this.varience = varience;
    }

    public Double getMonthendcount() {
        return monthendcount;
    }

    public void setMonthendcount(Double monthendcount) {
        this.monthendcount = monthendcount;
    }

    public Double getWastage() {
        return wastage;
    }

    public void setWastage(Double wastage) {
        this.wastage = wastage;
    }

    @XmlTransient
    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
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
        return itemcode.toString();
    }
    
}
