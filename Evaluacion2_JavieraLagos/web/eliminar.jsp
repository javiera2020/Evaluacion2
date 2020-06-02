

<%@page import="Entidades.Jugador"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Eliminar" method="post">
            <% String codigo = request.getParameter("codigo");
               ArrayList<Jugador> jugadores = new ArrayList();
               if(session.getAttribute("jugadores")!=null){
                   jugadores =(ArrayList) session.getAttribute("jugadores");
               }   
               Jugador j = new Jugador();
               for(Jugador jugador:jugadores){
                   if(Jugador.getId().equalsIgnoreCase(id)){
                       j = jugador;
                   }
               }
            %>
            <table style="border: 1; ">
                    <tr>
                        <td>Id</td>
                        <td><input type="text" name="id" value="<%= j.getId()%>"
                                   readonly="true" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" value="<%= j.getNombre()%>" readonly="true" /></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="Apellido" value="<%= j.getApellido()%>" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Edad</td>
                        <td><input type="date" name="Edad" value="<%= j.getEdad()%>" readonly="true"/></td>
                    </tr>
                     <tr>
                        <td>Posicion</td>
                        <td><input type="text" name="posicion" value="<%= j.getPosicion()%>" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td><a href="intranet.jsp">Volver</a></td>
                        <td><input type="submit" value="Eliminar"/></td>
                    </tr>
                    <input type="hidden" name="accion" value="3"/>
                </table> 
           <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        </form>
    </body>
</html>
