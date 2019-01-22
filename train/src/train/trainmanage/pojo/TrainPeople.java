package train.trainmanage.pojo;
// default package



/**
 * TrainPeople entity. @author MyEclipse Persistence Tools
 */
public class TrainPeople extends AbstractTrainPeople implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TrainPeople() {
    }

    
    /** full constructor */
    public TrainPeople(String number, String signpeople, String markpeople, String exampeople) {
        super(number, signpeople, markpeople, exampeople);        
    }
   
}
