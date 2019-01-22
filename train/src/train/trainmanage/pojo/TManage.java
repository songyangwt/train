package train.trainmanage.pojo;
// default package



/**
 * TManage entity. @author MyEclipse Persistence Tools
 */
public class TManage extends AbstractTManage implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TManage() {
    }

    
    /** full constructor */
    public TManage(Integer chu, String manager, String content, String people, String time, String location, String requirement, String number, String programname, String tel, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, Integer type, Integer issign, Integer isregister, Integer isexam, Integer isevaluate, String coursewarenum, String remark, String teacher) {
        super(chu, manager, content, people, time, location, requirement, number, programname, tel, process, jindu, date, status, preunder, thisunder, initiator, type, issign, isregister, isexam, isevaluate, coursewarenum, remark, teacher);        
    }
   
}
