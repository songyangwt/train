package train.userinfo.pojo;
// default package



/**
 * AbstractUserInfo entity provides the base persistence definition of the UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer chu;
     private String authority;
     private Integer zhi;
     private String newnumber;
     private String username;


    // Constructors

    /** default constructor */
    public AbstractUserInfo() {
    }

    
    /** full constructor */
    public AbstractUserInfo(Integer chu, String authority, Integer zhi, String newnumber, String username) {
        this.chu = chu;
        this.authority = authority;
        this.zhi = zhi;
        this.newnumber = newnumber;
        this.username = username;
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

    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getZhi() {
        return this.zhi;
    }
    
    public void setZhi(Integer zhi) {
        this.zhi = zhi;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
   








}