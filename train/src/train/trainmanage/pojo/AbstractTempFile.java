package train.trainmanage.pojo;
// default package



/**
 * AbstractTempFile entity provides the base persistence definition of the TempFile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTempFile  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String filename;
     private String number;


    // Constructors

    /** default constructor */
    public AbstractTempFile() {
    }

    
    /** full constructor */
    public AbstractTempFile(String name, String filename, String number) {
        this.name = name;
        this.filename = filename;
        this.number = number;
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

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
   








}