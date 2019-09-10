import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Email = request.getParameter("email");
		String Name = request.getParameter("fullname");
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println(Name);
		System.out.println(Email);
		System.out.println(Username);
		out.println(Name);
		out.print("you are successfully Registered");
		
		



		try {
			Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/collegeDB", "postgres",
					"root")) {

				if (conn != null) {
					System.out.println("Connected to the database!");

					Statement stmnt = null;
					stmnt = conn.createStatement();
                  
					// Inserting data into database
					java.sql.PreparedStatement pst = null;
					String sql = "INSERT INTO public.\"stud\"(\"email\",\"fullname\",\"username\",\"password\") VALUES (?, ?, ?, ?)";

					pst = conn.prepareStatement(sql);
					pst.setString(1, Email);
					pst.setString(2, Name);
					pst.setString(3, Username);
					pst.setString(4, Password);
					ResultSet rs = pst.executeQuery();
					
					
					// delete the data from database
//					 String sql3 = "DELETE FROM public.\"stud\" WHERE \"fullname\" = 'prajakta' ";
//					 stmnt = conn.createStatement();
//					 stmnt.execute(sql3);
					 
					 
					  // update data into th database
					// String sql2 = "UPDATE public.\"stud\" SET \"fullname\" = 'prajakta' WHERE \"Password\" = '122'  ";
					// stmnt = conn.createStatement();
					// stmnt.execute(sql2);
					 
					//read data from database

					ResultSet rs1 = stmnt.executeQuery("select * from public.\"stud\"");
					while (rs1.next()) {
						System.out.println(rs1.getString(1));
						System.out.println(rs1.getString(2));
						System.out.println(rs1.getString(3));
						System.out.println(rs1.getInt(4));
						
						
					}

				} else {
					System.out.println("Failed to make connection!");
				}
				 

			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
