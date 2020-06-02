

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h1>Ingreso</h1>
        <form action="Ingreso" method="Post">
            
            <table style="border: 1;">
                <tr>
                    <td> Usuario </td>
                    <td><input type="text" name="usuario" /></td>         
                </tr>
                
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password">
                </tr>
                
                <tr>
                    <td> <a href="registro.jsp">Registrar</a></td>
                    <td><input type="submit" value="Ingresar"</td>
                </tr>
            </table>
            <% if(request.getParameter("mensaje")!=null){%>
            <%=request.getParameter("mensaje") %>
            <%}%>
        </form>
    </body>
</html>
