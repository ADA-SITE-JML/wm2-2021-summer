package ada.wm2.db;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/database-servlet")
public class DBServlet extends HttpServlet {
    DataSource dataSource;

    @Override
    public void init () throws ServletException {
        super.init();
        Context initContext = null;
        try{
            initContext = new InitialContext();
            Context webContext = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)webContext.lookup("jdbc/studentdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String first = request.getParameter("first");
            String last = request.getParameter("last");
            String school = request.getParameter("school");

            String sql = "INSERT INTO STUDENTS(st_first,st_last,school) VALUES(?,?,?)";

            Connection connection = dataSource.getConnection();
            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1,first);
            pstat.setString(2,last);
            pstat.setString(3,school);
            int res = pstat.executeUpdate();
            PrintWriter writer = response.getWriter();

            writer.print("<html><head></head>");
            writer.print("<body><pre><h2>    Students Table</h2></pre>");
            writer.print("Inserted "+res+" rows");

            writer.close();
            connection.close();
        }
        catch (Exception ex) {
           System.out.println("Error:" + ex);
        }
    }


    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String school = request.getParameter("school");

            Connection connection = dataSource.getConnection();
            String sql= "SELECT ST_ID,ST_FIRST,ST_LAST FROM students WHERE school = ?";

            PreparedStatement pstat = connection.prepareStatement(sql);
            pstat.setString(1,school);

            ResultSet resultSet = pstat.executeQuery();

            PrintWriter writer = response.getWriter();

            writer.print("<html><head></head>");
            writer.print("<body><pre><h2>    Students Table</h2></pre>");
            writer.print("<table style=border-spacing:10px;>");
            writer.print("<tr>");
                writer.print("<th>ID</th>");
                writer.print("<th>First Name</th>");
                writer.print("<th>Last Name</th>");
            writer.print("</tr>");
            while(resultSet.next()){

                writer.print("<tr>");
                    writer.print("<td>" + resultSet.getInt(1) + "</td>");
                    writer.print("<td>" + resultSet.getString(2) + "</td>");
                    writer.print("<td>" + resultSet.getString(3) + "</td>");
                writer.print("</tr>");

            }
            writer.print("</table></body></html>");

            writer.close();
            connection.close();

        }
        catch (Exception ex) {
           System.out.println("Error:" + ex);
        }
    }
}
