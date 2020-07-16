/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeManagementFunction;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manthi
 */
@Entity
@Table(name = "SALARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s")
    , @NamedQuery(name = "Salary.findBySalaryid", query = "SELECT s FROM Salary s WHERE s.salaryid = :salaryid")
    , @NamedQuery(name = "Salary.findByTotalamount", query = "SELECT s FROM Salary s WHERE s.totalamount = :totalamount")
    , @NamedQuery(name = "Salary.findByTotalsal", query = "SELECT s FROM Salary s WHERE s.totalsal = :totalsal")
    , @NamedQuery(name = "Salary.findByYearno", query = "SELECT s FROM Salary s WHERE s.yearno = :yearno")
    , @NamedQuery(name = "Salary.findByMonthname", query = "SELECT s FROM Salary s WHERE s.monthname = :monthname")
    , @NamedQuery(name = "Salary.findByDate", query = "SELECT s FROM Salary s WHERE s.date = :date")
    , @NamedQuery(name = "Salary.findByOthours", query = "SELECT s FROM Salary s WHERE s.othours = :othours")})
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SALARYID")
    private Integer salaryid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALAMOUNT")
    private Double totalamount;
    @Column(name = "TOTALSAL")
    private Double totalsal;
    @Column(name = "YEARNO")
    private Integer yearno;
    @Column(name = "MONTHNAME")
    private String monthname;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "OTHOURS")
    private Integer othours;
    @JoinColumn(name = "EMPID", referencedColumnName = "EMPLOYEEID")
    @ManyToOne
    private Employee empid;
    @JoinColumn(name = "JOBID", referencedColumnName = "JOBID")
    @ManyToOne
    private Job jobid;

    public Salary() {
    }

    public Salary(Integer salaryid) {
        this.salaryid = salaryid;
    }

    public Integer getSalaryid() {
        return salaryid;
    }

    public void setSalaryid(Integer salaryid) {
        this.salaryid = salaryid;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Double getTotalsal() {
        return totalsal;
    }

    public void setTotalsal(Double totalsal) {
        this.totalsal = totalsal;
    }

    public Integer getYearno() {
        return yearno;
    }

    public void setYearno(Integer yearno) {
        this.yearno = yearno;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOthours() {
        return othours;
    }

    public void setOthours(Integer othours) {
        this.othours = othours;
    }

    public Employee getEmpid() {
        return empid;
    }

    public void setEmpid(Employee empid) {
        this.empid = empid;
    }

    public Job getJobid() {
        return jobid;
    }

    public void setJobid(Job jobid) {
        this.jobid = jobid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryid != null ? salaryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.salaryid == null && other.salaryid != null) || (this.salaryid != null && !this.salaryid.equals(other.salaryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "employeeManagementFunction.Salary[ salaryid=" + salaryid + " ]";
    }
    
}
