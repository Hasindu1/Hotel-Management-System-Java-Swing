package eventManagementFunction;

import eventManagementFunction.Hallbooking;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T02:26:07")
@StaticMetamodel(Hall.class)
public class Hall_ { 

    public static volatile CollectionAttribute<Hall, Hallbooking> hallbookingCollection;
    public static volatile SingularAttribute<Hall, Integer> hallid;
    public static volatile SingularAttribute<Hall, String> halltype;
    public static volatile SingularAttribute<Hall, String> hallno;
    public static volatile SingularAttribute<Hall, Double> hallprice;

}