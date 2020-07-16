package BarManagementFunction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Barstockcontrol.class)
public class Barstockcontrol_ { 

    public static volatile SingularAttribute<Barstockcontrol, Date> date;
    public static volatile SingularAttribute<Barstockcontrol, Integer> productid;
    public static volatile SingularAttribute<Barstockcontrol, Double> priceperunit;
    public static volatile SingularAttribute<Barstockcontrol, String> productname;
    public static volatile SingularAttribute<Barstockcontrol, Double> amountperunit;
    public static volatile SingularAttribute<Barstockcontrol, String> standardunit;

}