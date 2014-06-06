package first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeliverShohinServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] orderId = req.getParameterValues("orderId");
        //long id[] = Long.parseLong(req.getParameters("orderId"));

        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        PizzaData data;
        for(int i=0; i<1; i++){
        	long id = Long.parseLong(orderId[i]);
        	data = (PizzaData)manager.getObjectById(PizzaData.class, id);
        	data.setOrder(1);
        }

        
        manager.close();
        resp.sendRedirect("/index.html");
    }

}
