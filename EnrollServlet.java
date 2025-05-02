import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");

        HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("username") == null) {
            
            response.sendRedirect("login.html");
            return;
        }

        
        List<String> enrolledCourses = (List<String>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }

        
        enrolledCourses.add(courseId);

       
        session.setAttribute("enrolledCourses", enrolledCourses);

        
        response.sendRedirect("DashboardServlet");
    }
}
