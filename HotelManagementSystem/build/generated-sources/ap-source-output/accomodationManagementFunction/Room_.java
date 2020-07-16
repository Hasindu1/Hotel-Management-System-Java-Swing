package accomodationManagementFunction;

import accomodationManagementFunction.Roombooking;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, String> roomno;
    public static volatile SingularAttribute<Room, Double> roomfprice;
    public static volatile SingularAttribute<Room, Double> roomhprice;
    public static volatile CollectionAttribute<Room, Roombooking> roombookingCollection;
    public static volatile SingularAttribute<Room, Integer> roomid;
    public static volatile SingularAttribute<Room, String> roomtype;

}