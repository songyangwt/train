package train.mycalendar.pojo;
// default package



/**
 * t_mycalendar entity. @author MyEclipse Persistence Tools
 */
public class t_mycalendar extends Abstractt_mycalendar implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public t_mycalendar() {
    }

    
    /** full constructor */
    public t_mycalendar(String date, Integer week, Integer workday, String remark) {
        super(date, week, workday, remark);        
    }
   
}
