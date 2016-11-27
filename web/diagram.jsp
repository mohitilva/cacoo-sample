<%-- 
   
    Author     : mtilva
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cacoo - Diagrams</title>
    </head>
    <%
        ArrayList<String> urls = (ArrayList<String>) request.getAttribute("diagramUrls");
        int size = urls.size();
    %>
    <body>
        <h1>Diagrams Page</h1>
        <% if (size > 0) {%>
            <div>
                These are your diagrams.
            </div>
            <br> 
            <table>
            <% for (String imageurl : (ArrayList<String>) request.getAttribute("diagramUrls")) {%>
                <tr> <td> <img width="75" height="75" src="<%= imageurl%>"></td>
                    
                    <td> <a href="<%=request.getContextPath()%>/deletediag?diagramurl=<%=imageurl%>" > Delete </a>
                    </td></tr>
            <% } %>
            </table>
        <%  } else { %>
        <div>
            You do not have any diagrams. Add some diagrams and try again.
        </div>
        <% }%>
    </body>
</html>
