package train.userinfo.pojo;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    
    /** full constructor */
    public UserInfo(Integer chu, String authority, Integer zhi, String newnumber, String username) {
        super(chu, authority, zhi, newnumber, username);        
    }
   
}
