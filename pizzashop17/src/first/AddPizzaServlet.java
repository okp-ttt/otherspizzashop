package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.PizzaData;
import first.PMF;

public class AddPizzaServlet extends HttpServlet {
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
        String[] topping = req.getParameterValues("topping");
        String crust = req.getParameter("crust");
        
        int sum = topping.length*50;
        if(crust.equals("s")) sum += 100;
        else if(crust.equals("m")) sum+=200;
        else sum+=300;
        
        PizzaData data = new PizzaData(topping, crust);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        //(1)ContentTypeの指定
        resp.setContentType("text/html; charset=Windows-31J");

        //(2)PrintWriterオブジェクトの生成
        PrintWriter out = resp.getWriter();
        //(3)テキストデータの返信
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<table border=1> <tr>");
        out.println("<td>トッピング</td>");
        for(int i=0; i<topping.length; i++){
          	if(topping[i].equals("piman")) out.println("<td>ピーマン</td>");
        	else if(topping[i].equals("cheese")) out.println("<td>チーズ</td>");
        	else if(topping[i].equals("tomato")) out.println("<td>トマト</td>");
        	else if(topping[i].equals("sarami")) out.println("<td>サラミ</td>");
        	else if(topping[i].equals("coon")) out.println("<td>コーン</td>");
          }
        out.println("</tr>");
        out.println("<td>クラスト</td>");
        out.println("<td>"+crust+"</td></tr></table><br>");
        out.println("合計金額"+sum+"円でした。<br>");
        out.println("ご注文ありがとうございました。<br>");
        out.println("<A HREF='index.html'> 戻る</A><br>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();  //(4)データ返信の終了
    }
 }
