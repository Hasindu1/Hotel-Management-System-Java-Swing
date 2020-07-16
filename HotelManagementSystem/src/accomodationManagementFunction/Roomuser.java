/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationManagementFunction;

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
 * @author Hasindu
 */
@Entity
@Table(name = "ROOMUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomuser.findAll", query = "SELECT r FROM Roomuser r")
    , @NamedQuery(name = "Roomuser.findByGuestid", query = "SELECT r FROM Roomuser r WHERE r.guestid = :guestid")
    , @NamedQuery(name = "Roomuser.findByNicpassport", query = "SELECT r FROM Roomuser r WHERE r.nicpassport = :nicpassport")
    , @NamedQuery(name = "Roomuser.findByFname", query = "SELECT r FROM Roomuser r WHERE r.fname = :fname")
    , @NamedQuery(name = "Roomuser.findByLname", query = "SELECT r FROM Roomuser r WHERE r.lname = :lname")
    , @NamedQuery(name = "Roomuser.findByEmail", query = "SELECT r FROM Roomuser r WHERE r.email = :email")
    , @NamedQuery(name = "Roomuser.findByCountry", query = "SELECT r FROM Roomuser r WHERE r.country = :country")
    , @NamedQuery(name = "Roomuser.findByNoofrooms", query = "SELECT r FROM Roomuser r WHERE r.noofrooms = :noofrooms")
    , @NamedQuery(name = "Roomuser.findByRoomstatus", query = "SELECT r FROM Roomuser r WHERE r.roomstatus = :roomstatus")
    , @NamedQuery(name = "Roomuser.findByGender", query = "SELECT r FROM Roomuser r WHERE r.gender = :gender")
    , @NamedQuery(name = "Roomuser.findByNoofadults", query = "SELECT r FROM Roomuser r WHERE r.noofadults = :noofadults")
    , @NamedQuery(name = "Roomuser.findByNoofchildren", query = "SELECT r FROM Roomuser r WHERE r.noofchildren = :noofchildren")
    , @NamedQuery(name = "Roomuser.findByPhoto", query = "SELECT r FROM Roomuser r WHERE r.photo = :photo")})
public class Roomuser implements Serializable {

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
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "NOOFROOMS")
    private Integer noofrooms;
    @Column(name = "ROOMSTATUS")
    private Character roomstatus;
    @Column(name = "GENDER")
    private Character gender;
    @Column(name = "NOOFADULTS")
    private Integer noofadults;
    @Column(name = "NOOFCHILDREN")
    private Integer noofchildren;
    @Column(name = "PHOTO")
    private String photo;
    @OneToMany(mappedBy = "guestid")
    private Collection<Roombooking> roombookingCollection;

    public Roomuser() {
    }

    public Roomuser(Integer guestid) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(Integer noofrooms) {
        this.noofrooms = noofrooms;
    }

    public Character getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(Character roomstatus) {
        this.roomstatus = roomstatus;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getNoofadults() {
        return noofadults;
    }

    public void setNoofadults(Integer noofadults) {
        this.noofadults = noofadults;
    }

    public Integer getNoofchildren() {
        return noofchildren;
    }

    public void setNoofchildren(Integer noofchildren) {
        this.noofchildren = noofchildren;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlTransient
    public Collection<Roombooking> getRoombookingCollection() {
        return roombookingCollection;
    }

    public void setRoombookingCollection(Collection<Roombooking> roombookingCollection) {
        this.roombookingCollection = roombookingCollection;
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
        if (!(object instanceof Roomuser)) {
            return false;
        }
        Roomuser other = (Roomuser) object;
        if ((this.guestid == null && other.guestid != null) || (this.guestid != null && !this.guestid.equals(other.guestid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Roomuser[ guestid=" + guestid + " ]";
    }
    
}
