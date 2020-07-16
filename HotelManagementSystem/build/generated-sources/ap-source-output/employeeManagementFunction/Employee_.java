package employeeManagementFunction;

import employeeManagementFunction.Attendence;
import employeeManagementFunction.Job;
import employeeManagementFunction.Salary;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Job> jobid;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile CollectionAttribute<Employee, Salary> salaryCollection;
    public static volatile SingularAttribute<Employee, String> contactnumber;
    public static volatile SingularAttribute<Employee, String> currentjobrole;
    public static volatile SingularAttribute<Employee, Date> dob;
    public static volatile SingularAttribute<Employee, String> maritalstate;
    public static volatile CollectionAttribute<Employee, Attendence> attendenceCollection;
    public static volatile SingularAttribute<Employee, String> nicpassport;
    public static volatile SingularAttribute<Employee, Integer> employeeid;
    public static volatile SingularAttribute<Employee, String> employeename;

}