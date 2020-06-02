

<%@page import="Entidades.Jugador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
  <% if(session.getAttribute("usuario")!=null){ 
        Usuario u =(Usuario) session.getAttribute("usuario");%>
    <body>
        <h1>Bienvenido!</h1>
        <h2> Mantenedor </h2>
        <form action="ControlJugadores" method="post"> 
            <table>
                
                <tr>
                    
                    <td>Id</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Edad</td>
                    <td>Posicion</td>
                    <td>Sueldo</td>
                    <td>Equipo</td>
                </tr>
                
                <tr>
                    <td><input type="text" name="id" value="" /></td>
                    <td><input type="text" name="nombre" value="" /></td>
                    <td><input type="text" name="apellido" value="" /></td>
                    <td><input type="number" name="edad" value="" /></td>
                    <td><input type="text" name="posicion" value="" /></td>
                    <td><input type="numbre" name="sueldo" value="" /></td>
                    <td><input type="text" name="equipo" value="" /></td>
                   
                <td>
                    <input type="submit" value="Agregar" />
                </td>
                <td>
                    <a href="Salir">
                        <input type="button" value="Cerrar Sesion"/>
                    </a>
                </td>
                </tr>
                
                <% ArrayList<Jugador> jugadores= new ArrayList();
                if(session.getAttribute("jugadores")!=null){
                    jugadores = (ArrayList) session.getAttribute("jugadores");
                }
                for(Jugador j: jugadores){
                   %> 
               
                   <tr>
                       <td><%= j.getId()%></td>
                       <td><%= j.getNombre()%></td>
                       <td><%= j.getApellido()%></td>
                       <td><%= j.getEdad()%></td>
                       <td><%= j.getPosicion()%></td>
                       <td><%= j.getSueldo()%></td>
                       <td><%= j.getEquipo()%></td>
                       
                        <td><a href="modificar.jsp?id=<%=j.getId()%>">
                        <input type="button" value="Modificar" />
                    </a>
                        </td>
                        <td>
                    <a href="eliminar.jsp?patente=<%=j.getId()%>">
                        <input type="button" value="Eliminar" />
                    </a>
                </td>
            </tr>
            <% } %>
                
            </table>
            
        </form>
             <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
    </body>
</html>
