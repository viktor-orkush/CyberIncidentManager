package servlet;

import Databases.IncidentTable;
import POJO.TypeIncd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectIncidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<TypeIncd> arrIncident = new ArrayList<TypeIncd>();
        arrIncident = IncidentTable.getAllColumn();

        /*arrTypeIncident.add(new POJO.AlgorAction(1, "dos", "00:05"));
        arrTypeIncident.add(new POJO.AlgorAction(2, "scaning", "00:10"));
*/      System.out.print("arrrrrr" + arrIncident.get(0));
        req.setAttribute("arrIncident", arrIncident);

        req.getRequestDispatcher("selectIncid.jsp").forward(req, resp);
    }
}
