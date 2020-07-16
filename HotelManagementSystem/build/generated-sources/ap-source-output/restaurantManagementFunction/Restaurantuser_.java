package restaurantManagementFunction;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurantManagementFunction.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Restaurantuser.class)
public class Restaurantuser_ { 

    public static volatile SingularAttribute<Restaurantuser, Integer> seafood;
    public static volatile SingularAttribute<Restaurantuser, Integer> soup;
    public static volatile SingularAttribute<Restaurantuser, Integer> beverages;
    public static volatile SingularAttribute<Restaurantuser, Integer> other;
    public static volatile SingularAttribute<Restaurantuser, String> contactnumber;
    public static volatile SingularAttribute<Restaurantuser, Integer> puddings;
    public static volatile SingularAttribute<Restaurantuser, Integer> noodles;
    public static volatile SingularAttribute<Restaurantuser, Integer> vegetabledishes;
    public static volatile SingularAttribute<Restaurantuser, String> preference;
    public static volatile CollectionAttribute<Restaurantuser, Orders> ordersCollection;
    public static volatile SingularAttribute<Restaurantuser, Integer> rice;
    public static volatile SingularAttribute<Restaurantuser, Integer> meatdishes;
    public static volatile SingularAttribute<Restaurantuser, String> nicpassport;
    public static volatile SingularAttribute<Restaurantuser, String> fullname;
    public static volatile SingularAttribute<Restaurantuser, Integer> menus;
    public static volatile SingularAttribute<Restaurantuser, Integer> guestid;
    public static volatile SingularAttribute<Restaurantuser, String> email;

}