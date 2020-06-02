<%-- 
    Document   : modificar
    Created on : 02-jun-2020, 0:53:32
    Author     : javil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Jugador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("usuario")!=null){%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
    <body>
        <h1>Cambie los datos que desea modificar</h1>
        <form action="ControlJugador" method="post">
            <% String id = request.getParameter("id");
            ArrayList<Jugador> jugadores = new ArrayList();
            if(session.getAttribute("jugadores")!=null){
             jugadores = (ArrayList) session.getAttribute("jugadores");
     
            }
            Jugador j = new Jugador();
            for(Jugador jugador:jugadores){
                if(jugador.getId().equalsIgnoreCase(id)){
                    j= jugador;
                }
            }
           %>     
           
           <table>
               <tr>
                   <td>Id</td>
                   <td><input type="text" name="patente" value="<%= j.getId()%>" readonly="true" /></td>
               </tr>
               
                <tr>
                   <td>Nombre</td>
                   <td><input type="text" name="nombre" value="<%= j.getNombre()%>" /></td>
               </tr>
               
                <tr>
                   <td>Apellido</td>
                   <td><input type="text" name="apellido" value="<%= j.getApellido()%>" /></td>
               </tr>
               
                <tr>
                   <td>Edad</td>
                   <td><input type="number" name="edad" value="<%= j.getEdad()%>" /></td>
               </tr>
               
                <tr>
                   <td>Posicion</td>
                   <td><input type="text" name="posicion" value="<%= j.getPosicion()%>" /></td>
               </tr>
               
                <tr>
                   <td>Sueldo</td>
                   <td><input type="number" name="sueldo" value="<%= j.getSueldo()%>" /></td>
               </tr>
               
                <tr>
                   <td>Equipo</td>
                   <td><input type="text" name="equipo" value="<%= j.getEquipo()%>" /></td>
               </tr>
               
                <tr>
                    <td><a href="intranet.jsp">Volver</a></td>
                   <td><input type="submit"  value="Modificar" /></td>
               </tr>
               <input type="hidden" name="accion" value="2"/>
           </table>
                   <% if (request.getParameter("mensaje")!=null){%>
                   <%= request.getParameter("mensaje")%>
                   <%{%>
                   
                   
                   
           </form>
           
    </body>
</html>
