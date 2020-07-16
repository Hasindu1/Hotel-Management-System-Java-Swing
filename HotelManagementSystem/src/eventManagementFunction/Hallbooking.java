/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventManagementFunction;

import eventManagementFunction.Hall;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Malki
 */
@Entity
@Table(name = "HALLBOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hallbooking.findAll", query = "SELECT h FROM Hallbooking h")
    , @NamedQuery(name = "Hallbooking.findByBookingid", query = "SELECT h FROM Hallbooking h WHERE h.bookingid = :bookingid")
    , @NamedQuery(name = "Hallbooking.findByCheckin", query = "SELECT h FROM Hallbooking h WHERE h.checkin = :checkin")
    , @NamedQuery(name = "Hallbooking.findByCheckout", query = "SELECT h FROM Hallbooking h WHERE h.checkout = :checkout")
    , @NamedQuery(name = "Hallbooking.findByTotalprice", query = "SELECT h FROM Hallbooking h WHERE h.totalprice = :totalprice")
    , @NamedQuery(name = "Hallbooking.findByPriceperplate", query = "SELECT h FROM Hallbooking h WHERE h.priceperplate = :priceperplate")
    , @NamedQuery(name = "Hallbooking.findByNoofplates", query = "SELECT h FROM Hallbooking h WHERE h.noofplates = :noofplates")
    , @NamedQuery(name = "Hallbooking.findByDiscount", query = "SELECT h FROM Hallbooking h WHERE h.discount = :discount")
    , @NamedQuery(name = "Hallbooking.findByAmount", query = "SELECT h FROM Hallbooking h WHERE h.amount = :amount")})
public class Hallbooking implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @Column(name = "TOTALPRICE")
    private Double totalprice;
    @Column(name = "PRICEPERPLATE")
    private Double priceperplate;
    @Column(name = "NOOFPLATES")
    private Integer noofplates;
    @Column(name = "DISCOUNT")
    private Double discount;
    @Column(name = "AMOUNT")
    private Double amount;
    @JoinTable(name = "HALLBOOKING_HALL", joinColumns = {
        @JoinColumn(name = "BOOKINGID", referencedColumnName = "BOOKINGID")}, inverseJoinColumns = {
        @JoinColumn(name = "HALLID", referencedColumnName = "HALLID")})
    @ManyToMany
    private Collection<Hall> hallCollection;
    @JoinColumn(name = "GUESTID", referencedColumnName = "GUESTID")
    @ManyToOne
    private Halluser guestid;

    public Hallbooking() {
    }

    public Hallbooking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        Integer oldBookingid = this.bookingid;
        this.bookingid = bookingid;
        changeSupport.firePropertyChange("bookingid", oldBookingid, bookingid);
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        Date oldCheckin = this.checkin;
        this.checkin = checkin;
        changeSupport.firePropertyChange("checkin", oldCheckin, checkin);
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        Date oldCheckout = this.checkout;
        this.checkout = checkout;
        changeSupport.firePropertyChange("checkout", oldCheckout, checkout);
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        Double oldTotalprice = this.totalprice;
        this.totalprice = totalprice;
        changeSupport.firePropertyChange("totalprice", oldTotalprice, totalprice);
    }

    public Double getPriceperplate() {
        return priceperplate;
    }

    public void setPriceperplate(Double priceperplate) {
        Double oldPriceperplate = this.priceperplate;
        this.priceperplate = priceperplate;
        changeSupport.firePropertyChange("priceperplate", oldPriceperplate, priceperplate);
    }

    public Integer getNoofplates() {
        return noofplates;
    }

    public void setNoofplates(Integer noofplates) {
        Integer oldNoofplates = this.noofplates;
        this.noofplates = noofplates;
        changeSupport.firePropertyChange("noofplates", oldNoofplates, noofplates);
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        Double oldDiscount = this.discount;
        this.discount = discount;
        changeSupport.firePropertyChange("discount", oldDiscount, discount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        Double oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    @XmlTransient
    public Collection<Hall> getHallCollection() {
        return hallCollection;
    }

    public void setHallCollection(Collection<Hall> hallCollection) {
        this.hallCollection = hallCollection;
    }

    public Halluser getGuestid() {
        return guestid;
    }

    public void setGuestid(Halluser guestid) {
        Halluser oldGuestid = this.guestid;
        this.guestid = guestid;
        changeSupport.firePropertyChange("guestid", oldGuestid, guestid);
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
        if (!(object instanceof Hallbooking)) {
            return false;
        }
        Hallbooking other = (Hallbooking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelmanagementsystem.Hallbooking[ bookingid=" + bookingid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
