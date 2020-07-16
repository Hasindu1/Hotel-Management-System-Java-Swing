package employeeManagementFunction;

import employeeManagementFunction.Employee;
import employeeManagementFunction.Job;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Salary.class)
public class Salary_ { 

    public static volatile SingularAttribute<Salary, Date> date;
    public static volatile SingularAttribute<Salary, Employee> empid;
    public static volatile SingularAttribute<Salary, Job> jobid;
    public static volatile SingularAttribute<Salary, Double> totalamount;
    public static volatile SingularAttribute<Salary, Integer> yearno;
    public static volatile SingularAttribute<Salary, String> monthname;
    public static volatile SingularAttribute<Salary, Integer> othours;
    public static volatile SingularAttribute<Salary, Double> totalsal;
    public static volatile SingularAttribute<Salary, Integer> salaryid;

}