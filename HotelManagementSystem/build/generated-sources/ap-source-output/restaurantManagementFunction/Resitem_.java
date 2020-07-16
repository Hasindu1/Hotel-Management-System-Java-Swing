package restaurantManagementFunction;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurantManagementFunction.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Resitem.class)
public class Resitem_ { 

    public static volatile SingularAttribute<Resitem, Integer> itemid;
    public static volatile SingularAttribute<Resitem, String> itemname;
    public static volatile SingularAttribute<Resitem, Double> price;
    public static volatile CollectionAttribute<Resitem, Orders> ordersCollection;
    public static volatile SingularAttribute<Resitem, String> category;
    public static volatile SingularAttribute<Resitem, Integer> qtyonhand;

}