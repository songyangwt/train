package train.trainmanage.pojo;
// default package



/**
 * AbstractTrainPeople entity provides the base persistence definition of the TrainPeople entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTrainPeople  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String signpeople;
     private String markpeople;
     private String exampeople;


    // Constructors

    /** default constructor */
    public AbstractTrainPeople() {
    }

    
    /** full constructor */
    public AbstractTrainPeople(String number, String signpeople, String markpeople, String exampeople) {
        this.number = number;
        this.signpeople = signpeople;
        this.markpeople = markpeople;
        this.exampeople = exampeople;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getSignpeople() {
        return this.signpeople;
    }
    
    public void setSignpeople(String signpeople) {
        this.signpeople = signpeople;
    }

    public String getMarkpeople() {
        return this.markpeople;
    }
    
    public void setMarkpeople(String markpeople) {
        this.markpeople = markpeople;
    }

    public String getExampeople() {
        return this.exampeople;
    }
    
    public void setExampeople(String exampeople) {
        this.exampeople = exampeople;
    }
   








}