

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import DatabaseHandler;
@WebServlet("/registerServlet")
@SuppressWarnings("serial")

public class registerServlet extends HttpServlet {
    private DatabaseHandler dbHandler = new DatabaseHandler();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isRegistered = dbHandler.registerUser(username, email, password);

        if (isRegistered) {
            System.out.println("DEBUG: Registration Successful!");
            response.getWriter().write("Registration Successful!");
        } else {
            System.out.println("DEBUG: Registration Failed! Email already exists.");
            response.getWriter().write("Registration Failed. Email already exists.");
        }
    }
}
