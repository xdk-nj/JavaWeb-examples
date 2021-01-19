package servlet;

import javax.servlet.*;
import javax.sound.midi.Soundbank;
import javax.swing.text.html.HTMLWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class MyServlet implements Servlet {

    @Override
    public void destroy() {}

    @Override
    public void init(ServletConfig config) throws ServletException {
        // xml中配置的 servlet-name
        String servletName = config.getServletName();
        System.out.println("servletName: " + servletName);
        System.out.println(config.getInitParameter("name"));
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            String val = config.getInitParameter(key);
            System.out.println("key:" + key + "--" + "val:" + val);
        }
        // servlet上下文，整个servlet管理者
        ServletContext context = config.getServletContext();
        System.out.println(context.getContextPath());
        System.out.println(context.getServerInfo());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("myservlet service, id =" + id);
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.write("我已收到消息！");
        out.flush();
        out.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
