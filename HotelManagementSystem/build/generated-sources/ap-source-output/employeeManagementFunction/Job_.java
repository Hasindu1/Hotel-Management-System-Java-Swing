package employeeManagementFunction;

import employeeManagementFunction.Employee;
import employeeManagementFunction.Salary;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, Integer> jobid;
    public static volatile SingularAttribute<Job, Double> basicsalary;
    public static volatile CollectionAttribute<Job, Salary> salaryCollection;
    public static volatile CollectionAttribute<Job, Employee> employeeCollection;
    public static volatile SingularAttribute<Job, String> jobrole;
    public static volatile SingularAttribute<Job, Double> otrte;

}