
package controladores;

import Entidades.Jugador;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControlJugador", urlPatterns = {"/ControlJugador"})
public class ControlJugador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": ingresar(request,response);
            break;
            case "2": modificar(request,response);
            break;
            case "3": eliminar(request,response);
            break;
        }
        }
        catch(Exception e){
            response.sendRedirect("index.jsp?mensaje=Complete todos los campos");
        }
    }
    private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
        if(validar(request)==null){
            Jugador j = new Jugador(getString("id",request),getString("nombre",request),
            getString("apellido",request),getString("edad",request),getString("pocicion",request),getInt("sueldo",request),getString("equipo",request));
            ArrayList<Jugador> jugadores;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("jugadores")!=null){
                jugadores = (ArrayList) sesion.getAttribute("jugadores");
            }else{
                jugadores = new ArrayList();
            }
            jugadores.add(j);
            sesion.setAttribute("jugadores", jugadores);
            response.sendRedirect("intranet.jsp?mensaje=Jugador registrado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Id ya existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Jugador antiguo = validar(request);
        if(antiguo !=null){
            antiguo.setNombre(getString("nombre",request));
            antiguo.setApellido(getString("apellido",request));
            antiguo.setEdad(getString("edad",request));
            antiguo.setPosicion(getString("pocision",request));
            antiguo.setSueldo(getInt("sueldo",request));
            antiguo.setEquipo(getString("equipo",request));
            response.sendRedirect("intranet.jsp?mensaje=Jugador Modificado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Jugador no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Jugador antiguo = validar(request);
        if(antiguo!=null){
            ArrayList<Jugador> jugadores ;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("jugadores")!=null){
               jugadores = (ArrayList) sesion.getAttribute("jugadores");
            }else{
                jugadores= new ArrayList();
            }
            jugadores.remove(antiguo);
            sesion.setAttribute("jugadores", jugadores);
            response.sendRedirect("intranet.jsp?mensaje=Jugador Eliminado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Id no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    
    private Jugador validar(HttpServletRequest request){
        Jugador j = null;
        HttpSession sesion = request.getSession();
        ArrayList<Jugador> jugadores=(ArrayList)sesion.getAttribute("jugadores");
        if(jugadores!=null){
            for (Jugador jugador: jugadores) {
                if(jugador.getId().equalsIgnoreCase(getString("id",request))){
                    
                }
            }
        }
       
        return j;
    }
    private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }
}
