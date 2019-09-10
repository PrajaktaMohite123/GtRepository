
import java.sql.*;

import javax.servlet.annotation.WebServlet;

public class Validate {
    public static boolean checkUser(String username,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
        	Class.forName("org.postgresql.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/collegeDB", "postgres","root");
            PreparedStatement ps = con.prepareStatement("select * from stud where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}