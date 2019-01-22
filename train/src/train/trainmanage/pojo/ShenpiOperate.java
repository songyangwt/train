package train.trainmanage.pojo;
// default package



/**
 * ShenpiOperate entity. @author MyEclipse Persistence Tools
 */
public class ShenpiOperate extends AbstractShenpiOperate implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ShenpiOperate() {
    }

    
    /** full constructor */
    public ShenpiOperate(String number, String time, String viewer, String viewernewnumber, String role, String authority, Integer opinion, String remark) {
        super(number, time, viewer, viewernewnumber, role, authority, opinion, remark);        
    }
   
}
