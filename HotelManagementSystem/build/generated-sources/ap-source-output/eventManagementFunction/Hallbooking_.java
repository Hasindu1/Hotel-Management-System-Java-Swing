package eventManagementFunction;

import eventManagementFunction.Hall;
import eventManagementFunction.Halluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Hallbooking.class)
public class Hallbooking_ { 

    public static volatile SingularAttribute<Hallbooking, Double> priceperplate;
    public static volatile SingularAttribute<Hallbooking, Integer> noofplates;
    public static volatile SingularAttribute<Hallbooking, Double> amount;
    public static volatile SingularAttribute<Hallbooking, Date> checkin;
    public static volatile CollectionAttribute<Hallbooking, Hall> hallCollection;
    public static volatile SingularAttribute<Hallbooking, Double> totalprice;
    public static volatile SingularAttribute<Hallbooking, Double> discount;
    public static volatile SingularAttribute<Hallbooking, Date> checkout;
    public static volatile SingularAttribute<Hallbooking, Halluser> guestid;
    public static volatile SingularAttribute<Hallbooking, Integer> bookingid;

}