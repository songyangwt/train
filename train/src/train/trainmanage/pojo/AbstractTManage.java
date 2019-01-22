package train.trainmanage.pojo;
// default package



/**
 * AbstractTManage entity provides the base persistence definition of the TManage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTManage  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer chu;
     private String manager;
     private String content;
     private String people;
     private String time;
     private String location;
     private String requirement;
     private String number;
     private String programname;
     private String tel;
     private Integer process;
     private String jindu;
     private String date;
     private Integer status;
     private String preunder;
     private String thisunder;
     private String initiator;
     private Integer type;
     private Integer issign;
     private Integer isregister;
     private Integer isexam;
     private Integer isevaluate;
     private String coursewarenum;
     private String remark;
     private String teacher;


    // Constructors

    /** default constructor */
    public AbstractTManage() {
    }

    
    /** full constructor */
    public AbstractTManage(Integer chu, String manager, String content, String people, String time, String location, String requirement, String number, String programname, String tel, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, Integer type, Integer issign, Integer isregister, Integer isexam, Integer isevaluate, String coursewarenum, String remark, String teacher) {
        this.chu = chu;
        this.manager = manager;
        this.content = content;
        this.people = people;
        this.time = time;
        this.location = location;
        this.requirement = requirement;
        this.number = number;
        this.programname = programname;
        this.tel = tel;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preunder = preunder;
        this.thisunder = thisunder;
        this.initiator = initiator;
        this.type = type;
        this.issign = issign;
        this.isregister = isregister;
        this.isexam = isexam;
        this.isevaluate = isevaluate;
        this.coursewarenum = coursewarenum;
        this.remark = remark;
        this.teacher = teacher;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChu() {
        return this.chu;
    }
    
    public void setChu(Integer chu) {
        this.chu = chu;
    }

    public String getManager() {
        return this.manager;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
        this.people = people;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getRequirement() {
        return this.requirement;
    }
    
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getProgramname() {
        return this.programname;
    }
    
    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getProcess() {
        return this.process;
    }
    
    public void setProcess(Integer process) {
        this.process = process;
    }

    public String getJindu() {
        return this.jindu;
    }
    
    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPreunder() {
        return this.preunder;
    }
    
    public void setPreunder(String preunder) {
        this.preunder = preunder;
    }

    public String getThisunder() {
        return this.thisunder;
    }
    
    public void setThisunder(String thisunder) {
        this.thisunder = thisunder;
    }

    public String getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIssign() {
        return this.issign;
    }
    
    public void setIssign(Integer issign) {
        this.issign = issign;
    }

    public Integer getIsregister() {
        return this.isregister;
    }
    
    public void setIsregister(Integer isregister) {
        this.isregister = isregister;
    }

    public Integer getIsexam() {
        return this.isexam;
    }
    
    public void setIsexam(Integer isexam) {
        this.isexam = isexam;
    }

    public Integer getIsevaluate() {
        return this.isevaluate;
    }
    
    public void setIsevaluate(Integer isevaluate) {
        this.isevaluate = isevaluate;
    }

    public String getCoursewarenum() {
        return this.coursewarenum;
    }
    
    public void setCoursewarenum(String coursewarenum) {
        this.coursewarenum = coursewarenum;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
   








}