/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationManagementFunction;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "ROOMBOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roombooking.findAll", query = "SELECT r FROM Roombooking r")
    , @NamedQuery(name = "Roombooking.findByBookingid", query = "SELECT r FROM Roombooking r WHERE r.bookingid = :bookingid")
    , @NamedQuery(name = "Roombooking.findByCheckin", query = "SELECT r FROM Roombooking r WHERE r.checkin = :checkin")
    , @NamedQuery(name = "Roombooking.findByCheckout", query = "SELECT r FROM Roombooking r WHERE r.checkout = :checkout")
    , @NamedQuery(name = "Roombooking.findByPayment", query = "SELECT r FROM Roombooking r WHERE r.payment = :payment")
    , @NamedQuery(name = "Roombooking.findByDiscount", query = "SELECT r FROM Roombooking r WHERE r.discount = :discount")
    , @NamedQuery(name = "Roombooking.findByTotalpayment", query = "SELECT r FROM Roombooking r WHERE r.totalpayment = :totalpayment")
    , @NamedQuery(name = "Roombooking.findByPaymenttype", query = "SELECT r FROM Roombooking r WHERE r.paymenttype = :paymenttype")})
public class Roombooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKINGID")
    private Integer bookingid;
    @Column(name = "CHECKIN")
    @Temporal(TemporalType.DATE)
    private Date checkin;
    @Column(name = "CHECKOUT")
    @Temporal(TemporalType.DATE)
    private Date checkout;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENT")
    private Double payment;
    @Column(name = "DISCOUNT")
    private Double discount;
    @Column(name = "TOTALPAYMENT")
    private Double totalpayment;
    @Column(name = "PAYMENTTYPE")
    private Character paymenttype;
    @JoinTable(name = "BOOKING_ROOM", joinColumns = {
        @JoinColumn(name = "BOOKINGID", referencedColumnName = "BOOKINGID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROOMID", referencedColumnName = "ROOMID")})
    @ManyToMany
    private Collection<Room> roomCollection;
    @JoinColumn(name = "GUESTID", referencedColumnName = "GUESTID")
    @ManyToOne
    private Roomuser guestid;

    public Roombooking() {
    }

    public Roombooking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(Double totalpayment) {
        this.totalpayment = totalpayment;
    }

    public Character getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Character paymenttype) {
        this.paymenttype = paymenttype;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public Roomuser getGuestid() {
        return guestid;
    }

    public void setGuestid(Roomuser guestid) {
        this.guestid = guestid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roombooking)) {
            return false;
        }
        Roombooking other = (Roombooking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Roombooking[ bookingid=" + bookingid + " ]";
    }
    
}
