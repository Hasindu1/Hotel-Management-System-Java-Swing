/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierManagement;

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
 * @author Kaushalya
 */
@Entity
@Table(name = "SUPPLIERDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplierdetails.findAll", query = "SELECT s FROM Supplierdetails s")
    , @NamedQuery(name = "Supplierdetails.findBySupplierid", query = "SELECT s FROM Supplierdetails s WHERE s.supplierid = :supplierid")
    , @NamedQuery(name = "Supplierdetails.findByNic", query = "SELECT s FROM Supplierdetails s WHERE s.nic = :nic")
    , @NamedQuery(name = "Supplierdetails.findByFirstname", query = "SELECT s FROM Supplierdetails s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Supplierdetails.findByLastname", query = "SELECT s FROM Supplierdetails s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Supplierdetails.findByContactnumber", query = "SELECT s FROM Supplierdetails s WHERE s.contactnumber = :contactnumber")
    , @NamedQuery(name = "Supplierdetails.findByEmail", query = "SELECT s FROM Supplierdetails s WHERE s.email = :email")
    , @NamedQuery(name = "Supplierdetails.findByCompanyname", query = "SELECT s FROM Supplierdetails s WHERE s.companyname = :companyname")})
public class Supplierdetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SUPPLIERID")
    private Integer supplierid;
    @Column(name = "NIC")
    private String nic;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COMPANYNAME")
    private String companyname;
    @OneToMany(mappedBy = "supplierid")
    private Collection<Orderdetails> orderdetailsCollection;

    public Supplierdetails() {
    }

    public Supplierdetails(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        Integer oldSupplierid = this.supplierid;
        this.supplierid = supplierid;
        changeSupport.firePropertyChange("supplierid", oldSupplierid, supplierid);
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        String oldNic = this.nic;
        this.nic = nic;
        changeSupport.firePropertyChange("nic", oldNic, nic);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        String oldContactnumber = this.contactnumber;
        this.contactnumber = contactnumber;
        changeSupport.firePropertyChange("contactnumber", oldContactnumber, contactnumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        String oldCompanyname = this.companyname;
        this.companyname = companyname;
        changeSupport.firePropertyChange("companyname", oldCompanyname, companyname);
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
        hash += (supplierid != null ? supplierid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplierdetails)) {
            return false;
        }
        Supplierdetails other = (Supplierdetails) object;
        if ((this.supplierid == null && other.supplierid != null) || (this.supplierid != null && !this.supplierid.equals(other.supplierid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return supplierid.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
