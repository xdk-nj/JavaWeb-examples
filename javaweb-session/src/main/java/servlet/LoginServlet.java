package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String passwd = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        User user = new User();
        user.setId(1);
        user.setName("去年夏天");
        user.setAddress("北京");
        session.setAttribute("user", user);
        resp.sendRedirect("/welcome.jsp");
    }
}
