package Controller;

import Model.Repository.UserRoleRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/LoginServlet", ""})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("remember");
        HttpSession session = request.getSession();

        boolean check = UserRoleRepository.checkLogin(username, password, request);
        if (check) {
            Cookie c1 = new Cookie("cUsername", username);
            c1.setMaxAge(60 * 60 * 24 * 7); // set age to 2 years
            c1.setPath("/");                      // allow entire app to access it
            response.addCookie(c1);

            Cookie c2 = new Cookie("cPassword", password);
            c2.setMaxAge(60 * 60 * 24 * 7);
            c2.setPath("/");
            response.addCookie(c2);

            if (checkbox != null) {
                Cookie c = new Cookie("checkbox", checkbox);
                c.setMaxAge(60 * 60 * 24 * 7);
                c.setPath("/");
                response.addCookie(c);
            } else {
                deleteCookies(request, response);
            }
            session.setAttribute("failed", "");
            response.sendRedirect("/home");
        } else {
            deleteCookies(request, response);
            session.setAttribute("failed", "Please enter again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("cUsername".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if ("cPassword".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if ("checkbox".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }
}
