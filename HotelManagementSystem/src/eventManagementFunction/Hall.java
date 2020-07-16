/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventManagementFunction;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Malki
 */
@Entity
@Table(name = "HALL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h")
    , @NamedQuery(name = "Hall.findByHallid", query = "SELECT h FROM Hall h WHERE h.hallid = :hallid")
    , @NamedQuery(name = "Hall.findByHallno", query = "SELECT h FROM Hall h WHERE h.hallno = :hallno")
    , @NamedQuery(name = "Hall.findByHalltype", query = "SELECT h FROM Hall h WHERE h.halltype = :halltype")
    , @NamedQuery(name = "Hall.findByHallprice", query = "SELECT h FROM Hall h WHERE h.hallprice = :hallprice")})
public class Hall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HALLID")
    private Integer hallid;
    @Column(name = "HALLNO")
    private String hallno;
    @Column(name = "HALLTYPE")
    private String halltype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HALLPRICE")
    private Double hallprice;
    @ManyToMany(mappedBy = "hallCollection")
    private Collection<Hallbooking> hallbookingCollection;

    public Hall() {
    }

    public Hall(Integer hallid) {
        this.hallid = hallid;
    }

    public Integer getHallid() {
        return hallid;
    }

    public void setHallid(Integer hallid) {
        this.hallid = hallid;
    }

    public String getHallno() {
        return hallno;
    }

    public void setHallno(String hallno) {
        this.hallno = hallno;
    }

    public String getHalltype() {
        return halltype;
    }

    public void setHalltype(String halltype) {
        this.halltype = halltype;
    }

    public Double getHallprice() {
        return hallprice;
    }

    public void setHallprice(Double hallprice) {
        this.hallprice = hallprice;
    }

    @XmlTransient
    public Collection<Hallbooking> getHallbookingCollection() {
        return hallbookingCollection;
    }

    public void setHallbookingCollection(Collection<Hallbooking> hallbookingCollection) {
        this.hallbookingCollection = hallbookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hallid != null ? hallid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hall)) {
            return false;
        }
        Hall other = (Hall) object;
        if ((this.hallid == null && other.hallid != null) || (this.hallid != null && !this.hallid.equals(other.hallid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Hall[ hallid=" + hallid + " ]";
    }
    
}
