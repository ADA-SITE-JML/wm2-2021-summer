package ada.wm2;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();
			writer.println("<HTML>");
			writer.println("<HEAD><TITLE>GET Request</TITLE></HEAD>");
			writer.println("<BODY><h1>Sorry, but we do not support GET...</h1></BODY>");
			writer.println("</HTML>");
		}
		catch (Exception ex) {
			System.out.println("Problem in doGet(): " + ex);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String psw = request.getParameter("password");
		if (!("admin".equals(login) && "abc123".equals(psw) )) {
			// redirect to login
			try {
				response.sendRedirect("login.html");
			}
			catch (Exception ex) {
				System.out.println("Redirect problem: "+ex);
			}
		}
		else {
			ArrayList<StudentBean> al = new ArrayList<>();
			StudentBean sb = new StudentBean();
			sb.setFirstName("Fagan"); sb.setLastName("Rasulov"); sb.setMajor("BSIT");
			al.add(sb);
			sb = new StudentBean();
			sb.setFirstName("Khanim"); sb.setLastName("Huseynzade"); sb.setMajor("BSIT");
			al.add(sb);
			sb = new StudentBean();
			sb.setFirstName("Emil"); sb.setLastName("Huseynov"); sb.setMajor("BSIT");
			al.add(sb);
			sb = new StudentBean();
			sb.setFirstName("Nuray"); sb.setLastName("Leysanli"); sb.setMajor("BSIT");
			al.add(sb);
			sb = new StudentBean();
			sb.setFirstName("Mammadqulu"); sb.setLastName("Novruzov"); sb.setMajor("BSCS");
			al.add(sb);
	
			HttpSession session = request.getSession();
			session.setAttribute("students",al);
			try {
				RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
				rd.forward(request,response);
			}
			catch (Exception ex) {
				System.out.println("Forward problem: "+ex);
			}
		}

	}
}
