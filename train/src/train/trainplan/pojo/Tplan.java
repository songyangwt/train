package train.trainplan.pojo;
// default package



/**
 * Tplan entity. @author MyEclipse Persistence Tools
 */
public class Tplan extends AbstractTplan implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Tplan() {
    }

    
    /** full constructor */
    public Tplan(Integer chu, String manager, String content, String people, String time, String location, String remark, String year) {
        super(chu, manager, content, people, time, location, remark, year);        
    }
   
}
