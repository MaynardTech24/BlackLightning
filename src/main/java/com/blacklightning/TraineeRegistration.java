package com.blacklightning;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class TraineeRegistration
 */
@WebServlet("/TraineeRegistration")
public class TraineeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String fullName = request.getParameter("fullname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contact");
		String email = request.getParameter("email");
		String emergencyName = request.getParameter("emergency");
		String emergencyNumber = request.getParameter("emergency_number");
		String trainingProgram = request.getParameter("program");
		String previousExperience = request.getParameter("experience");
		
		String sql = "INSERT INTO trainees "
		        + "(full_name, age, gender, birthdate, address, "
		        + "contact_number, email, emergency_contact_name, "
		        + "emergency_contact_number, training_program, "
		        + "previous_experience) "
		        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
		    Connection conn = DBConnection.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    
		    pstmt.setString(1, fullName);
		    pstmt.setInt(2, Integer.parseInt(age));
		    pstmt.setString(3, gender);
		    pstmt.setString(4, birthdate);
		    pstmt.setString(5, address);
		    pstmt.setString(6, contactNumber);
		    pstmt.setString(7, email);
		    pstmt.setString(8, emergencyName);
		    pstmt.setString(9, emergencyNumber);
		    pstmt.setString(10, trainingProgram);
		    pstmt.setString(11, previousExperience);
		    
		    pstmt.executeUpdate();

		    pstmt.close();
		    conn.close();
		    
		    response.setContentType("text/html");
		    response.getWriter().println("<script>");
		    response.getWriter().println("alert('Registration submitted successfully!');");
		    response.getWriter().println("window.location.href='index.html';");
		    response.getWriter().println("</script>");
		
		} catch (Exception e) {
		    e.printStackTrace();

		    response.setContentType("text/html");
		    response.getWriter().println("<h2>Registration Error</h2>");
		    response.getWriter().println("<pre>");
		    response.getWriter().println(e.toString());
		    response.getWriter().println("</pre>");
		}
		
	

}
}
