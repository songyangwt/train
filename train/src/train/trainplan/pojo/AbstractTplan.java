package train.trainplan.pojo;
// default package



/**
 * AbstractTplan entity provides the base persistence definition of the Tplan entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTplan  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer chu;
     private String manager;
     private String content;
     private String people;
     private String time;
     private String location;
     private String remark;
     private String year;


    // Constructors

    /** default constructor */
    public AbstractTplan() {
    }

    
    /** full constructor */
    public AbstractTplan(Integer chu, String manager, String content, String people, String time, String location, String remark, String year) {
        this.chu = chu;
        this.manager = manager;
        this.content = content;
        this.people = people;
        this.time = time;
        this.location = location;
        this.remark = remark;
        this.year = year;
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

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
   








}