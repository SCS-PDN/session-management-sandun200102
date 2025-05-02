import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username.equals("student1") && password.equals("pass1")) ||
            (username.equals("student2") && password.equals("pass2"))) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(userCookie);

            response.sendRedirect("DashboardServlet");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
