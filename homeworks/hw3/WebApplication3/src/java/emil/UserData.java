package emil;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emil
 */

public class UserData {
    java.sql.Connection con ;

    public UserData(java.sql.Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{ 
           //Insert register data to database
           String query = "insert into user(email,password) values(?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getEmail());
           pt.setString(2, user.getPassword());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    public User loginUser(String email, String password) {
        User user = null;
        try{
            String query = "select * from user where email=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setSurname(rs.getString("surname"));
                user.setName(rs.getString("name"));
            } else {
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
