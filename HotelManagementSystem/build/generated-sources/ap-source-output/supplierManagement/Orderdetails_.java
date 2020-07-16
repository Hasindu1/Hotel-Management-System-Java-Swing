package supplierManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import supplierManagement.Supplierdetails;
import supplierManagement.Supplieritems;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Orderdetails.class)
public class Orderdetails_ { 

    public static volatile SingularAttribute<Orderdetails, Double> total;
    public static volatile SingularAttribute<Orderdetails, Integer> quantity;
    public static volatile SingularAttribute<Orderdetails, Supplierdetails> supplierid;
    public static volatile SingularAttribute<Orderdetails, Integer> orderid;
    public static volatile SingularAttribute<Orderdetails, Supplieritems> itemcode;
    public static volatile SingularAttribute<Orderdetails, Date> orderdate;
    public static volatile SingularAttribute<Orderdetails, Double> unitprice;

}