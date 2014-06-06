package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class CheckShohinServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<PizzaData> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + PizzaData.class.getName();
            try {
                list = (List<PizzaData>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
            	PizzaData data = (PizzaData)manager.getObjectById(PizzaData.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        
        String crust,piman,cheese,tomato,sarami,coon,order;
        int no=1;
        
        if (list != null){
            for(PizzaData data:list){
            	if(data.getOrder()==0){
            		if(data.getPiman()==0) piman="";
            		else piman="○";
            		if(data.getCheese()==0) cheese="";
            		else cheese="○";
            		if(data.getTomato()==0) tomato="";
            		else tomato="○";
            		if(data.getSarami()==0) sarami="";
            		else sarami="○";
            		if(data.getCoon()==0) coon="";
            		else coon="○";
            		
            		res += "{id:'" + data.getId()
            				+ "',no:'" + no
            				+ "',crust:'" + data.getCrust() 
            				+ "',piman:'" + piman
            				+ "',cheese:'" + cheese
            				+ "',tomato:'" + tomato
            				+ "',sarami:'" + sarami
            				+ "',coon:'" + coon
            				+ "',order:'" +data.getOrder()
            				+"'},";
            		no++;
            	}
            }
        }
        
        
        /*if (list != null){
            for(PizzaData data:list){
                res += "{id:'" + data.getId()
                		+ "',crust:'" + data.getCrust() 
                		+ "',piman:'" +data.getPiman()
                		+ "',cheese:'" + data.getCheese()
                		+ "',tomato:'" +data.getTomato()
                		+ "',sarami:'" +data.getSarami()
                		+ "',coon:'" +data.getCoon()
                		+ "',order:'" +data.getOrder()
                		+"'},";
            }
        }*/
        res += "]";
        out.println(res);
        manager.close();
    }

}
