<%-- 
    Document   : registro
    Created on : 01-jun-2020, 20:25:08
    Author     : javil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Registro </h1>
        <form action="Registro" method="post"> 
            
            <table style="border: 1;">
                
                <tr>
                    <td> Usuario</td>
                    <td><input type="text" name="usuario"/></td>
                </tr>
                
                <tr>
                    <td> Nombre </td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                
                <tr>
                    <td> Apellido </td>
                    <td><input type="text" name="apellido"/></td>
                </tr>
                
                <tr>
                    <td> Password </td>
                    <td><input type="password" name="password"/></td>
                </tr>
                
                <tr>
                    <td><a href="index.jsp">Volver</a></td>
                    <td><input type="submit" value="Registrar"/></td>
                </tr>
                 <input type="hidden" name="accion" value="1"/>   
            </table>
             <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        </form>
    </body>
</html>
