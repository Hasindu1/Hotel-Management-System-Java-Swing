/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeManagementFunction;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manthi
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeid", query = "SELECT e FROM Employee e WHERE e.employeeid = :employeeid")
    , @NamedQuery(name = "Employee.findByEmployeename", query = "SELECT e FROM Employee e WHERE e.employeename = :employeename")
    , @NamedQuery(name = "Employee.findByNicpassport", query = "SELECT e FROM Employee e WHERE e.nicpassport = :nicpassport")
    , @NamedQuery(name = "Employee.findByDob", query = "SELECT e FROM Employee e WHERE e.dob = :dob")
    , @NamedQuery(name = "Employee.findByMaritalstate", query = "SELECT e FROM Employee e WHERE e.maritalstate = :maritalstate")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByContactnumber", query = "SELECT e FROM Employee e WHERE e.contactnumber = :contactnumber")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByCurrentjobrole", query = "SELECT e FROM Employee e WHERE e.currentjobrole = :currentjobrole")})
public class Employee implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPLOYEEID")
    private Integer employeeid;
    @Column(name = "EMPLOYEENAME")
    private String employeename;
    @Column(name = "NICPASSPORT")
    private String nicpassport;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "MARITALSTATE")
    private String maritalstate;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "CURRENTJOBROLE")
    private String currentjobrole;
    @OneToMany(mappedBy = "empid")
    private Collection<Salary> salaryCollection;
    @OneToMany(mappedBy = "employeeid")
    private Collection<Attendence> attendenceCollection;
    @JoinColumn(name = "JOBID", referencedColumnName = "JOBID")
    @ManyToOne
    private Job jobid;

    public Employee() {
    }

    public Employee(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        Integer oldEmployeeid = this.employeeid;
        this.employeeid = employeeid;
        changeSupport.firePropertyChange("employeeid", oldEmployeeid, employeeid);
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        String oldEmployeename = this.employeename;
        this.employeename = employeename;
        changeSupport.firePropertyChange("employeename", oldEmployeename, employeename);
    }

    public String getNicpassport() {
        return nicpassport;
    }

    public void setNicpassport(String nicpassport) {
        String oldNicpassport = this.nicpassport;
        this.nicpassport = nicpassport;
        changeSupport.firePropertyChange("nicpassport", oldNicpassport, nicpassport);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public String getMaritalstate() {
        return maritalstate;
    }

    public void setMaritalstate(String maritalstate) {
        String oldMaritalstate = this.maritalstate;
        this.maritalstate = maritalstate;
        changeSupport.firePropertyChange("maritalstate", oldMaritalstate, maritalstate);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        String oldContactnumber = this.contactnumber;
        this.contactnumber = contactnumber;
        changeSupport.firePropertyChange("contactnumber", oldContactnumber, contactnumber);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getCurrentjobrole() {
        return currentjobrole;
    }

    public void setCurrentjobrole(String currentjobrole) {
        String oldCurrentjobrole = this.currentjobrole;
        this.currentjobrole = currentjobrole;
        changeSupport.firePropertyChange("currentjobrole", oldCurrentjobrole, currentjobrole);
    }

    @XmlTransient
    public Collection<Salary> getSalaryCollection() {
        return salaryCollection;
    }

    public void setSalaryCollection(Collection<Salary> salaryCollection) {
        this.salaryCollection = salaryCollection;
    }

    @XmlTransient
    public Collection<Attendence> getAttendenceCollection() {
        return attendenceCollection;
    }

    public void setAttendenceCollection(Collection<Attendence> attendenceCollection) {
        this.attendenceCollection = attendenceCollection;
    }

    public Job getJobid() {
        return jobid;
    }

    public void setJobid(Job jobid) {
        Job oldJobid = this.jobid;
        this.jobid = jobid;
        changeSupport.firePropertyChange("jobid", oldJobid, jobid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "employeeManagementFunction.Employee[ employeeid=" + employeeid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
