/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilva.cacoo.servlet;

import com.tilva.cacoo.exception.GenericException;
import com.tilva.cacoo.util.NetUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;

/**
 *
 * @author mtilva
 * Ideally we want to use diagram id to delete the urls. Here we parse the diagram id from the imageUrl.
 */
public class DeleteDiagramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String imageUrl = request.getParameter("diagramurl");
        String apiKey = (String)request.getSession().getAttribute("apiKey");
        RequestDispatcher dispatcher;
        
        if (imageUrl != null && !imageUrl.equals("")) {

            try {
                String[] tokens = imageUrl.split("/");
                String diagramImg = tokens[tokens.length - 1];
                tokens = diagramImg.split("\\.");
                String diagramId = tokens[0];
                NetUtils.deleteDiagram(diagramId, apiKey);
                dispatcher = request.getRequestDispatcher("/MainServlet");
                
            }  catch (GenericException ex) {
                log("Exception:" + ex.getMessage());
                dispatcher = request.getRequestDispatcher("/error.jsp?msg="+ex.getMessage());
            } 
            
            dispatcher.forward(request, response);
            
           
        }

    }
}
