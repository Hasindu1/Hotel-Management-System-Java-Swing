package restaurantManagementFunction;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurantManagementFunction.Bookedtable;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Restables.class)
public class Restables_ { 

    public static volatile CollectionAttribute<Restables, Bookedtable> bookedtableCollection;
    public static volatile SingularAttribute<Restables, Integer> restableid;
    public static volatile SingularAttribute<Restables, Integer> tableno;
    public static volatile SingularAttribute<Restables, Integer> capacity;

}