package train.config.pojo;
// default package

import javax.persistence.Entity;



/**
 * Config entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Config extends AbstractConfig implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Config() {
    }

    
    /** full constructor */
    public Config(String name, Integer value, String strvalue) {
        super(name, value, strvalue);        
    }
   
}
