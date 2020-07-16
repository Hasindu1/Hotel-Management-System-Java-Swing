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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByRoomid", query = "SELECT r FROM Room r WHERE r.roomid = :roomid")
    , @NamedQuery(name = "Room.findByRoomno", query = "SELECT r FROM Room r WHERE r.roomno = :roomno")
    , @NamedQuery(name = "Room.findByRoomtype", query = "SELECT r FROM Room r WHERE r.roomtype = :roomtype")
    , @NamedQuery(name = "Room.findByRoomfprice", query = "SELECT r FROM Room r WHERE r.roomfprice = :roomfprice")
    , @NamedQuery(name = "Room.findByRoomhprice", query = "SELECT r FROM Room r WHERE r.roomhprice = :roomhprice")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROOMID")
    private Integer roomid;
    @Column(name = "ROOMNO")
    private String roomno;
    @Column(name = "ROOMTYPE")
    private String roomtype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ROOMFPRICE")
    private Double roomfprice;
    @Column(name = "ROOMHPRICE")
    private Double roomhprice;
    @ManyToMany(mappedBy = "roomCollection")
    private Collection<Roombooking> roombookingCollection;

    public Room() {
    }

    public Room(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Double getRoomfprice() {
        return roomfprice;
    }

    public void setRoomfprice(Double roomfprice) {
        this.roomfprice = roomfprice;
    }

    public Double getRoomhprice() {
        return roomhprice;
    }

    public void setRoomhprice(Double roomhprice) {
        this.roomhprice = roomhprice;
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
        hash += (roomid != null ? roomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomid == null && other.roomid != null) || (this.roomid != null && !this.roomid.equals(other.roomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Room[ roomid=" + roomid + " ]";
    }
    
}
