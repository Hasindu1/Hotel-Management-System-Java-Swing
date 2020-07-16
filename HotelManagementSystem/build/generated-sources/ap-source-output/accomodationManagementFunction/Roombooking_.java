package accomodationManagementFunction;

import accomodationManagementFunction.Room;
import accomodationManagementFunction.Roomuser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Roombooking.class)
public class Roombooking_ { 

    public static volatile SingularAttribute<Roombooking, Date> checkin;
    public static volatile CollectionAttribute<Roombooking, Room> roomCollection;
    public static volatile SingularAttribute<Roombooking, Double> discount;
    public static volatile SingularAttribute<Roombooking, Double> payment;
    public static volatile SingularAttribute<Roombooking, Double> totalpayment;
    public static volatile SingularAttribute<Roombooking, Date> checkout;
    public static volatile SingularAttribute<Roombooking, Roomuser> guestid;
    public static volatile SingularAttribute<Roombooking, Integer> bookingid;
    public static volatile SingularAttribute<Roombooking, Character> paymenttype;

}