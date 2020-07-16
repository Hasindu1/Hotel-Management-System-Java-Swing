package restaurantManagementFunction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurantManagementFunction.Orders;
import restaurantManagementFunction.Restables;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Bookedtable.class)
public class Bookedtable_ { 

    public static volatile SingularAttribute<Bookedtable, Date> bookeddatetime;
    public static volatile SingularAttribute<Bookedtable, Integer> bookedtableid;
    public static volatile SingularAttribute<Bookedtable, Restables> restableid;
    public static volatile SingularAttribute<Bookedtable, Orders> orderid;

}