package train.trainmanage.pojo;
// default package



/**
 * TFile entity. @author MyEclipse Persistence Tools
 */
public class TFile extends AbstractTFile implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TFile() {
    }

    
    /** full constructor */
    public TFile(String name, String number, String filename) {
        super(name, number, filename);        
    }
   
}
