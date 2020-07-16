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
 * @author Manthi
 */
@Entity
@Table(name = "JOB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
    , @NamedQuery(name = "Job.findByJobid", query = "SELECT j FROM Job j WHERE j.jobid = :jobid")
    , @NamedQuery(name = "Job.findByJobrole", query = "SELECT j FROM Job j WHERE j.jobrole = :jobrole")
    , @NamedQuery(name = "Job.findByBasicsalary", query = "SELECT j FROM Job j WHERE j.basicsalary = :basicsalary")
    , @NamedQuery(name = "Job.findByOtrte", query = "SELECT j FROM Job j WHERE j.otrte = :otrte")})
public class Job implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JOBID")
    private Integer jobid;
    @Column(name = "JOBROLE")
    private String jobrole;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASICSALARY")
    private Double basicsalary;
    @Column(name = "OTRTE")
    private Double otrte;
    @OneToMany(mappedBy = "jobid")
    private Collection<Salary> salaryCollection;
    @OneToMany(mappedBy = "jobid")
    private Collection<Employee> employeeCollection;

    public Job() {
    }

    public Job(Integer jobid) {
        this.jobid = jobid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        Integer oldJobid = this.jobid;
        this.jobid = jobid;
        changeSupport.firePropertyChange("jobid", oldJobid, jobid);
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        String oldJobrole = this.jobrole;
        this.jobrole = jobrole;
        changeSupport.firePropertyChange("jobrole", oldJobrole, jobrole);
    }

    public Double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Double basicsalary) {
        Double oldBasicsalary = this.basicsalary;
        this.basicsalary = basicsalary;
        changeSupport.firePropertyChange("basicsalary", oldBasicsalary, basicsalary);
    }

    public Double getOtrte() {
        return otrte;
    }

    public void setOtrte(Double otrte) {
        Double oldOtrte = this.otrte;
        this.otrte = otrte;
        changeSupport.firePropertyChange("otrte", oldOtrte, otrte);
    }

    @XmlTransient
    public Collection<Salary> getSalaryCollection() {
        return salaryCollection;
    }

    public void setSalaryCollection(Collection<Salary> salaryCollection) {
        this.salaryCollection = salaryCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobid != null ? jobid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobid == null && other.jobid != null) || (this.jobid != null && !this.jobid.equals(other.jobid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "employeeManagementFunction.Job[ jobid=" + jobid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
