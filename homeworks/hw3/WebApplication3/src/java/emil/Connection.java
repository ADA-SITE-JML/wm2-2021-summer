package emil;


import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emil
 */
public class Connection {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("org.h2.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:h2:~/test","sa","");

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

