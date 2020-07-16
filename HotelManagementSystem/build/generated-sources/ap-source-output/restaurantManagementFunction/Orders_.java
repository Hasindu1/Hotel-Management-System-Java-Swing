package restaurantManagementFunction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurantManagementFunction.Bookedtable;
import restaurantManagementFunction.Resitem;
import restaurantManagementFunction.Restaurantuser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile CollectionAttribute<Orders, Bookedtable> bookedtableCollection;
    public static volatile SingularAttribute<Orders, Double> total;
    public static volatile SingularAttribute<Orders, Integer> orderid;
    public static volatile CollectionAttribute<Orders, Resitem> resitemCollection;
    public static volatile SingularAttribute<Orders, Date> orderdate;
    public static volatile SingularAttribute<Orders, Restaurantuser> guestid;
    public static volatile SingularAttribute<Orders, Date> handleddate;
    public static volatile SingularAttribute<Orders, Boolean> handledstatus;

}