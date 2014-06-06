package first;

import java.io.IOException;
import java.security.Principal;
 
import javax.servlet.*;
import javax.servlet.http.*;
 
import com.google.appengine.api.users.*;

@SuppressWarnings("serial")
public class UserAuthServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");

        UserService us = UserServiceFactory.getUserService();
        User user = us.getCurrentUser();
        
        us.createLoginURL("checkOrder.html");
    }
}