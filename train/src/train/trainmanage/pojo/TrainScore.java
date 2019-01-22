package train.trainmanage.pojo;
// default package



/**
 * TrainScore entity. @author MyEclipse Persistence Tools
 */
public class TrainScore extends AbstractTrainScore implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TrainScore() {
    }

    
    /** full constructor */
    public TrainScore(String number, String newnumber, Integer score1, Integer score2, Integer score3, Integer score4, Integer score5, Integer score6, Integer score7, Integer score8, Integer score9, Integer score10, String remark) {
        super(number, newnumber, score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, remark);        
    }
   
}
