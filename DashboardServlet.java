import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("username") : null;

        if (username == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Hardcoded list of courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSC2052", "Computer architecture", "Dr. Erunika"));
        courses.add(new Course("CSC2013", "Data Structures", "Prof. Ruwanthini"));
        courses.add(new Course("CSC3072", "Server side Web programming ", "prof.Isuru Madugalla"));

        // Store in request scope
        request.setAttribute("courseList", courses);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
