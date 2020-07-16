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
@Table(name = "ATTENDENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendence.findAll", query = "SELECT a FROM Attendence a")
    , @NamedQuery(name = "Attendence.findByAttendeceid", query = "SELECT a FROM Attendence a WHERE a.attendeceid = :attendeceid")
    , @NamedQuery(name = "Attendence.findByDate", query = "SELECT a FROM Attendence a WHERE a.date = :date")
    , @NamedQuery(name = "Attendence.findByMonth", query = "SELECT a FROM Attendence a WHERE a.month = :month")
    , @NamedQuery(name = "Attendence.findByWorkedhours", query = "SELECT a FROM Attendence a WHERE a.workedhours = :workedhours")
    , @NamedQuery(name = "Attendence.findByOvertimehours", query = "SELECT a FROM Attendence a WHERE a.overtimehours = :overtimehours")})
public class Attendence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ATTENDECEID")
    private Integer attendeceid;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "MONTH")
    private String month;
    @Column(name = "WORKEDHOURS")
    private Integer workedhours;
    @Column(name = "OVERTIMEHOURS")
    private Integer overtimehours;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID")
    @ManyToOne
    private Employee employeeid;

    public Attendence() {
    }

    public Attendence(Integer attendeceid) {
        this.attendeceid = attendeceid;
    }

    public Integer getAttendeceid() {
        return attendeceid;
    }

    public void setAttendeceid(Integer attendeceid) {
        this.attendeceid = attendeceid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getWorkedhours() {
        return workedhours;
    }

    public void setWorkedhours(Integer workedhours) {
        this.workedhours = workedhours;
    }

    public Integer getOvertimehours() {
        return overtimehours;
    }

    public void setOvertimehours(Integer overtimehours) {
        this.overtimehours = overtimehours;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendeceid != null ? attendeceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendence)) {
            return false;
        }
        Attendence other = (Attendence) object;
        if ((this.attendeceid == null && other.attendeceid != null) || (this.attendeceid != null && !this.attendeceid.equals(other.attendeceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "employeeManagementFunction.Attendence[ attendeceid=" + attendeceid + " ]";
    }
    
}
