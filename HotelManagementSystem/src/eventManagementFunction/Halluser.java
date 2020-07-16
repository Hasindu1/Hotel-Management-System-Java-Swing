/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventManagementFunction;

import eventManagementFunction.Hallbooking;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Malki
 */
@Entity
@Table(name = "HALLUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Halluser.findAll", query = "SELECT h FROM Halluser h")
    , @NamedQuery(name = "Halluser.findByGuestid", query = "SELECT h FROM Halluser h WHERE h.guestid = :guestid")
    , @NamedQuery(name = "Halluser.findByNicpassport", query = "SELECT h FROM Halluser h WHERE h.nicpassport = :nicpassport")
    , @NamedQuery(name = "Halluser.findByFname", query = "SELECT h FROM Halluser h WHERE h.fname = :fname")
    , @NamedQuery(name = "Halluser.findByLname", query = "SELECT h FROM Halluser h WHERE h.lname = :lname")
    , @NamedQuery(name = "Halluser.findByEmail", query = "SELECT h FROM Halluser h WHERE h.email = :email")
    , @NamedQuery(name = "Halluser.findByContactnumber", query = "SELECT h FROM Halluser h WHERE h.contactnumber = :contactnumber")
    , @NamedQuery(name = "Halluser.findByCountry", query = "SELECT h FROM Halluser h WHERE h.country = :country")})
public class Halluser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GUESTID")
    private Integer guestid;
    @Column(name = "NICPASSPORT")
    private String nicpassport;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(mappedBy = "guestid")
    private Collection<Hallbooking> hallbookingCollection;

    public Halluser() {
    }

    public Halluser(Integer guestid) {
        this.guestid = guestid;
    }

    public Integer getGuestid() {
        return guestid;
    }

    public void setGuestid(Integer guestid) {
        this.guestid = guestid;
    }

    public String getNicpassport() {
        return nicpassport;
    }

    public void setNicpassport(String nicpassport) {
        this.nicpassport = nicpassport;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        hash += (guestid != null ? guestid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Halluser)) {
            return false;
        }
        Halluser other = (Halluser) object;
        if ((this.guestid == null && other.guestid != null) || (this.guestid != null && !this.guestid.equals(other.guestid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Halluser[ guestid=" + guestid + " ]";
    }
    
}
