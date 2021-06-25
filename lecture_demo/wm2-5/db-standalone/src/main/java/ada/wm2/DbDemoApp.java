package ada.wm2;

import java.sql.*;

public class DbDemoApp 
{
    public void dbDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","jamal","aaa123");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT st_id, st_first, st_last, school FROM students");
        
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
        
            conn.close();
            }
            catch(Exception ex) {
                System.out.println(ex);
            }
        }

    public static void main( String[] args ) {
        DbDemoApp dda = new DbDemoApp();
        dda.dbDemo();
    }
}
