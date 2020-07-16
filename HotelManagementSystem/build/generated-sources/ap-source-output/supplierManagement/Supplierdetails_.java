package supplierManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import supplierManagement.Orderdetails;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Supplierdetails.class)
public class Supplierdetails_ { 

    public static volatile SingularAttribute<Supplierdetails, String> firstname;
    public static volatile CollectionAttribute<Supplierdetails, Orderdetails> orderdetailsCollection;
    public static volatile SingularAttribute<Supplierdetails, Integer> supplierid;
    public static volatile SingularAttribute<Supplierdetails, String> contactnumber;
    public static volatile SingularAttribute<Supplierdetails, String> companyname;
    public static volatile SingularAttribute<Supplierdetails, String> nic;
    public static volatile SingularAttribute<Supplierdetails, String> email;
    public static volatile SingularAttribute<Supplierdetails, String> lastname;

}