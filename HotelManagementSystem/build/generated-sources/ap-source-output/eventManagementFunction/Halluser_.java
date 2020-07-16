package eventManagementFunction;

import eventManagementFunction.Hallbooking;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Halluser.class)
public class Halluser_ { 

    public static volatile SingularAttribute<Halluser, String> fname;
    public static volatile SingularAttribute<Halluser, String> country;
    public static volatile SingularAttribute<Halluser, String> lname;
    public static volatile CollectionAttribute<Halluser, Hallbooking> hallbookingCollection;
    public static volatile SingularAttribute<Halluser, String> contactnumber;
    public static volatile SingularAttribute<Halluser, String> nicpassport;
    public static volatile SingularAttribute<Halluser, Integer> guestid;
    public static volatile SingularAttribute<Halluser, String> email;

}