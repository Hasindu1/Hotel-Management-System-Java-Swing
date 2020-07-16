package BarManagementFunction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Barorderbill.class)
public class Barorderbill_ { 

    public static volatile SingularAttribute<Barorderbill, Date> date;
    public static volatile SingularAttribute<Barorderbill, Integer> ordersid;
    public static volatile SingularAttribute<Barorderbill, Double> calamount;
    public static volatile SingularAttribute<Barorderbill, Double> totalbill;
    public static volatile SingularAttribute<Barorderbill, Double> discount;
    public static volatile SingularAttribute<Barorderbill, String> discountselect;
    public static volatile SingularAttribute<Barorderbill, String> status;

}