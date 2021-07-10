package ada.wm2.firstsb;

package saagnik;
import java.io.Serializable;


public class ValidateUser implements Serializable {
    private String user, pass;


    public void setUser(String u1) { this.user = u1; }
    public void setPass(String p1) { this.pass = p1; }

    public String getUser() { return user; }
    public String getPass() { return pass; }


    public boolean validate(String u1, String p1)
    {
        if (u1.equals(user) && p1.equals(pass))
            return true;
        else
            return false;
    }
}
