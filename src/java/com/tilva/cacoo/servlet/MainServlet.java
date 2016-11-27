package com.tilva.cacoo.servlet;

import com.tilva.cacoo.exception.GenericException;
import com.tilva.cacoo.util.CacooConstants;
import com.tilva.cacoo.util.NetUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import org.json.JSONException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apiKey = null;
        //has session variable  
        if (request.getParameter("apiKey") != null) {
            apiKey = request.getParameter("apiKey");
        }else if (request.getSession().getAttribute("apiKey") != null) {
            apiKey = (String) request.getSession().getAttribute("apiKey");
        }

        if (apiKey != null) {
            String nextJSP;
            RequestDispatcher dispatcher;
            try {
                HttpSession session = request.getSession();
                session.setAttribute("apiKey", apiKey);          
                List<String> diagramUrls = NetUtils.getDiagramsStringValues(CacooConstants.DIAGRAMS_JSON.IMAGE_URL, apiKey);
                request.setAttribute("diagramUrls", diagramUrls);
                nextJSP = "/diagram.jsp";
            }  catch (GenericException ex) {
                log("Exception:" + ex.getMessage());
                nextJSP = "/error.jsp?msg="+ex.getMessage();               
            }  catch (JSONException ex){
                log("Exception:" + ex.getMessage());
                nextJSP = "/error.jsp?msg="+ex.getMessage(); 
            }
            
            dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request, response);

        }

    }
}
