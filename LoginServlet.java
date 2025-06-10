import Database.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
@SuppressWarnings("serial")

public class LoginServlet extends HttpServlet {
    private DatabaseHandler dbHandler = new DatabaseHandler();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (dbHandler.loginUser(email, password)) {
            // Store user session
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);

            // Redirect to index.jsp after successful login
            response.sendRedirect("main.html");
        } else {
            // Redirect back to login page with an error message
            response.sendRedirect("main.jsp?error=Invalid credentials");
        }
    }
}