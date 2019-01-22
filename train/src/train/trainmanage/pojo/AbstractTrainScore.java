package train.trainmanage.pojo;
// default package



/**
 * AbstractTrainScore entity provides the base persistence definition of the TrainScore entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTrainScore  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String newnumber;
     private Integer score1;
     private Integer score2;
     private Integer score3;
     private Integer score4;
     private Integer score5;
     private Integer score6;
     private Integer score7;
     private Integer score8;
     private Integer score9;
     private Integer score10;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractTrainScore() {
    }

    
    /** full constructor */
    public AbstractTrainScore(String number, String newnumber, Integer score1, Integer score2, Integer score3, Integer score4, Integer score5, Integer score6, Integer score7, Integer score8, Integer score9, Integer score10, String remark) {
        this.number = number;
        this.newnumber = newnumber;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.score7 = score7;
        this.score8 = score8;
        this.score9 = score9;
        this.score10 = score10;
        this.remark = remark;
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

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public Integer getScore1() {
        return this.score1;
    }
    
    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return this.score2;
    }
    
    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return this.score3;
    }
    
    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public Integer getScore4() {
        return this.score4;
    }
    
    public void setScore4(Integer score4) {
        this.score4 = score4;
    }

    public Integer getScore5() {
        return this.score5;
    }
    
    public void setScore5(Integer score5) {
        this.score5 = score5;
    }

    public Integer getScore6() {
        return this.score6;
    }
    
    public void setScore6(Integer score6) {
        this.score6 = score6;
    }

    public Integer getScore7() {
        return this.score7;
    }
    
    public void setScore7(Integer score7) {
        this.score7 = score7;
    }

    public Integer getScore8() {
        return this.score8;
    }
    
    public void setScore8(Integer score8) {
        this.score8 = score8;
    }

    public Integer getScore9() {
        return this.score9;
    }
    
    public void setScore9(Integer score9) {
        this.score9 = score9;
    }

    public Integer getScore10() {
        return this.score10;
    }
    
    public void setScore10(Integer score10) {
        this.score10 = score10;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}