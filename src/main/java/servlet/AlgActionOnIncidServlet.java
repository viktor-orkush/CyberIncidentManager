package servlet;

import Databases.AlgDosTable;
import Databases.AlgScanTable;
import Databases.IncidentTable;
import POJO.AlgorAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AlgActionOnIncidServlet extends HttpServlet {

    ArrayList<AlgorAction> arrActionOnIncident;
    private int incidId;
    private String userName;
    private String incidName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userName = req.getParameter("username");
        incidId = Integer.parseInt(req.getParameter("typeIncid"));
        System.out.println("typeIncid = " + incidId);
        //incidId = Integer.parseInt(req.getParameter("incidId"));

        HttpSession session = req.getSession(true);

        switch (incidId) {
            case 1:
                arrActionOnIncident = AlgDosTable.getAllColumn();
                break;
            case 2:
                arrActionOnIncident = AlgScanTable.getAllColumn();
                break;
        }
        incidName = IncidentTable.getIncidNameById(incidId);

        Date today = new Date();   // given date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println("OLD !!!!!!! Session");
        if (session.isNew()) {
            session.setAttribute("userName", userName);
            session.setAttribute("incidId", incidId);
            System.out.println("NEW Session");

            ArrayList<String> arrTimeIncReact = new ArrayList<String>();
            for (AlgorAction actionOnIncident : arrActionOnIncident) {
                String timeFromDB = actionOnIncident.getTime();
                Date timeIncReact = new Date(today.getTime() + (Integer.parseInt(timeFromDB) * 60 * 1000));
                arrTimeIncReact.add(simpleDateFormat.format(timeIncReact));
                session.setAttribute("arrTimeIncReact", arrTimeIncReact);
                //actionOnIncident.setTime(simpleDateFormat.format(timeIncReact));
            }
        }

        //System.out.println("typeIncid" + typeIncid);
        req.setAttribute("arrActionOnIncident", arrActionOnIncident);
        req.setAttribute("incidName", incidName);
        req.getRequestDispatcher("algAction.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
