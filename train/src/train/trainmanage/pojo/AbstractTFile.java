package train.trainmanage.pojo;
// default package



/**
 * AbstractTFile entity provides the base persistence definition of the TFile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTFile  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String number;
     private String filename;


    // Constructors

    /** default constructor */
    public AbstractTFile() {
    }

    
    /** full constructor */
    public AbstractTFile(String name, String number, String filename) {
        this.name = name;
        this.number = number;
        this.filename = filename;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
   








}