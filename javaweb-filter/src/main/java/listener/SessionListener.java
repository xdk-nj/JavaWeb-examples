package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (null == count) {
            count = 1;
        } else {
            count++;
        }
        servletContext.setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (null == count) {
            count = 0;
        } else {
            count--;
        }
        servletContext.setAttribute("count", count);
    }
}
