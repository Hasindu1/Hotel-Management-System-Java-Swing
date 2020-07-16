package accomodationManagementFunction;

import accomodationManagementFunction.Roombooking;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Roomuser.class)
public class Roomuser_ { 

    public static volatile SingularAttribute<Roomuser, String> fname;
    public static volatile SingularAttribute<Roomuser, String> country;
    public static volatile SingularAttribute<Roomuser, Character> gender;
    public static volatile SingularAttribute<Roomuser, Integer> noofrooms;
    public static volatile SingularAttribute<Roomuser, Integer> noofadults;
    public static volatile SingularAttribute<Roomuser, String> photo;
    public static volatile SingularAttribute<Roomuser, String> lname;
    public static volatile SingularAttribute<Roomuser, Integer> noofchildren;
    public static volatile SingularAttribute<Roomuser, Character> roomstatus;
    public static volatile SingularAttribute<Roomuser, String> nicpassport;
    public static volatile SingularAttribute<Roomuser, Integer> guestid;
    public static volatile CollectionAttribute<Roomuser, Roombooking> roombookingCollection;
    public static volatile SingularAttribute<Roomuser, String> email;

}