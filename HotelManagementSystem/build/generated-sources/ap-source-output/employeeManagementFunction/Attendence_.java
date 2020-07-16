package employeeManagementFunction;

import employeeManagementFunction.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Attendence.class)
public class Attendence_ { 

    public static volatile SingularAttribute<Attendence, Date> date;
    public static volatile SingularAttribute<Attendence, Integer> overtimehours;
    public static volatile SingularAttribute<Attendence, String> month;
    public static volatile SingularAttribute<Attendence, Integer> workedhours;
    public static volatile SingularAttribute<Attendence, Employee> employeeid;
    public static volatile SingularAttribute<Attendence, Integer> attendeceid;

}