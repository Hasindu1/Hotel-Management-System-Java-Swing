/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hasindu
 */
@Entity
@Table(name = "RESTAURANTUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurantuser.findAll", query = "SELECT r FROM Restaurantuser r")
    , @NamedQuery(name = "Restaurantuser.findByGuestid", query = "SELECT r FROM Restaurantuser r WHERE r.guestid = :guestid")
    , @NamedQuery(name = "Restaurantuser.findByNicpassport", query = "SELECT r FROM Restaurantuser r WHERE r.nicpassport = :nicpassport")
    , @NamedQuery(name = "Restaurantuser.findByEmail", query = "SELECT r FROM Restaurantuser r WHERE r.email = :email")
    , @NamedQuery(name = "Restaurantuser.findByContactnumber", query = "SELECT r FROM Restaurantuser r WHERE r.contactnumber = :contactnumber")
    , @NamedQuery(name = "Restaurantuser.findByFullname", query = "SELECT r FROM Restaurantuser r WHERE r.fullname = :fullname")
    , @NamedQuery(name = "Restaurantuser.findByRice", query = "SELECT r FROM Restaurantuser r WHERE r.rice = :rice")
    , @NamedQuery(name = "Restaurantuser.findBySoup", query = "SELECT r FROM Restaurantuser r WHERE r.soup = :soup")
    , @NamedQuery(name = "Restaurantuser.findByNoodles", query = "SELECT r FROM Restaurantuser r WHERE r.noodles = :noodles")
    , @NamedQuery(name = "Restaurantuser.findByMeatdishes", query = "SELECT r FROM Restaurantuser r WHERE r.meatdishes = :meatdishes")
    , @NamedQuery(name = "Restaurantuser.findBySeafood", query = "SELECT r FROM Restaurantuser r WHERE r.seafood = :seafood")
    , @NamedQuery(name = "Restaurantuser.findByBeverages", query = "SELECT r FROM Restaurantuser r WHERE r.beverages = :beverages")
    , @NamedQuery(name = "Restaurantuser.findByVegetabledishes", query = "SELECT r FROM Restaurantuser r WHERE r.vegetabledishes = :vegetabledishes")
    , @NamedQuery(name = "Restaurantuser.findByPuddings", query = "SELECT r FROM Restaurantuser r WHERE r.puddings = :puddings")
    , @NamedQuery(name = "Restaurantuser.findByMenus", query = "SELECT r FROM Restaurantuser r WHERE r.menus = :menus")
    , @NamedQuery(name = "Restaurantuser.findByOther", query = "SELECT r FROM Restaurantuser r WHERE r.other = :other")
    , @NamedQuery(name = "Restaurantuser.findByPreference", query = "SELECT r FROM Restaurantuser r WHERE r.preference = :preference")})
public class Restaurantuser implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GUESTID")
    private Integer guestid;
    @Column(name = "NICPASSPORT")
    private String nicpassport;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "FULLNAME")
    private String fullname;
    @Column(name = "RICE")
    private Integer rice;
    @Column(name = "SOUP")
    private Integer soup;
    @Column(name = "NOODLES")
    private Integer noodles;
    @Column(name = "MEATDISHES")
    private Integer meatdishes;
    @Column(name = "SEAFOOD")
    private Integer seafood;
    @Column(name = "BEVERAGES")
    private Integer beverages;
    @Column(name = "VEGETABLEDISHES")
    private Integer vegetabledishes;
    @Column(name = "PUDDINGS")
    private Integer puddings;
    @Column(name = "MENUS")
    private Integer menus;
    @Column(name = "OTHER")
    private Integer other;
    @Column(name = "PREFERENCE")
    private String preference;
    @OneToMany(mappedBy = "guestid")
    private Collection<Orders> ordersCollection;

    public Restaurantuser() {
    }

    public Restaurantuser(Integer guestid) {
        this.guestid = guestid;
    }

    public Integer getGuestid() {
        return guestid;
    }

    public void setGuestid(Integer guestid) {
        Integer oldGuestid = this.guestid;
        this.guestid = guestid;
        changeSupport.firePropertyChange("guestid", oldGuestid, guestid);
    }

    public String getNicpassport() {
        return nicpassport;
    }

    public void setNicpassport(String nicpassport) {
        String oldNicpassport = this.nicpassport;
        this.nicpassport = nicpassport;
        changeSupport.firePropertyChange("nicpassport", oldNicpassport, nicpassport);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        String oldContactnumber = this.contactnumber;
        this.contactnumber = contactnumber;
        changeSupport.firePropertyChange("contactnumber", oldContactnumber, contactnumber);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        String oldFullname = this.fullname;
        this.fullname = fullname;
        changeSupport.firePropertyChange("fullname", oldFullname, fullname);
    }

    public Integer getRice() {
        return rice;
    }

    public void setRice(Integer rice) {
        Integer oldRice = this.rice;
        this.rice = rice;
        changeSupport.firePropertyChange("rice", oldRice, rice);
    }

    public Integer getSoup() {
        return soup;
    }

    public void setSoup(Integer soup) {
        Integer oldSoup = this.soup;
        this.soup = soup;
        changeSupport.firePropertyChange("soup", oldSoup, soup);
    }

    public Integer getNoodles() {
        return noodles;
    }

    public void setNoodles(Integer noodles) {
        Integer oldNoodles = this.noodles;
        this.noodles = noodles;
        changeSupport.firePropertyChange("noodles", oldNoodles, noodles);
    }

    public Integer getMeatdishes() {
        return meatdishes;
    }

    public void setMeatdishes(Integer meatdishes) {
        Integer oldMeatdishes = this.meatdishes;
        this.meatdishes = meatdishes;
        changeSupport.firePropertyChange("meatdishes", oldMeatdishes, meatdishes);
    }

    public Integer getSeafood() {
        return seafood;
    }

    public void setSeafood(Integer seafood) {
        Integer oldSeafood = this.seafood;
        this.seafood = seafood;
        changeSupport.firePropertyChange("seafood", oldSeafood, seafood);
    }

    public Integer getBeverages() {
        return beverages;
    }

    public void setBeverages(Integer beverages) {
        Integer oldBeverages = this.beverages;
        this.beverages = beverages;
        changeSupport.firePropertyChange("beverages", oldBeverages, beverages);
    }

    public Integer getVegetabledishes() {
        return vegetabledishes;
    }

    public void setVegetabledishes(Integer vegetabledishes) {
        Integer oldVegetabledishes = this.vegetabledishes;
        this.vegetabledishes = vegetabledishes;
        changeSupport.firePropertyChange("vegetabledishes", oldVegetabledishes, vegetabledishes);
    }

    public Integer getPuddings() {
        return puddings;
    }

    public void setPuddings(Integer puddings) {
        Integer oldPuddings = this.puddings;
        this.puddings = puddings;
        changeSupport.firePropertyChange("puddings", oldPuddings, puddings);
    }

    public Integer getMenus() {
        return menus;
    }

    public void setMenus(Integer menus) {
        Integer oldMenus = this.menus;
        this.menus = menus;
        changeSupport.firePropertyChange("menus", oldMenus, menus);
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        Integer oldOther = this.other;
        this.other = other;
        changeSupport.firePropertyChange("other", oldOther, other);
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        String oldPreference = this.preference;
        this.preference = preference;
        changeSupport.firePropertyChange("preference", oldPreference, preference);
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Restaurantuser)) {
            return false;
        }
        Restaurantuser other = (Restaurantuser) object;
        if ((this.guestid == null && other.guestid != null) || (this.guestid != null && !this.guestid.equals(other.guestid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return guestid.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
