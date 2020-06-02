
package controladores;

import Entidades.Equipo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControlEquipo", urlPatterns = {"/ControlEquipo"})
public class ControlEquipo extends HttpServlet {

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
            Equipo e  = new Equipo (getString("codigo",request),getString("nombre",request));
            ArrayList<Equipo> equipos;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("equipos")!=null){
                equipos = (ArrayList) sesion.getAttribute("equipos");
            }else{
                equipos = new ArrayList();
            }
            equipos.add(e);
            sesion.setAttribute("equipos", equipos);
            response.sendRedirect("intranet.jsp?mensaje=Equipo registrado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo ya existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Equipo antiguo = validar(request);
        if(antiguo !=null){
            antiguo.setNombre(getString("nombre",request));
           
            response.sendRedirect("intranet.jsp?mensaje=Equipo Modificado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Equipo no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Equipo antiguo = validar(request);
        if(antiguo!=null){
            ArrayList<Equipo> equipos ;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("equipos")!=null){
               equipos = (ArrayList) sesion.getAttribute("equipos");
            }else{
                equipos= new ArrayList();
            }
            equipos.remove(antiguo);
            sesion.setAttribute("equipos", equipos);
            response.sendRedirect("intranet.jsp?mensaje=Equipo Eliminado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    
    private Equipo validar(HttpServletRequest request){
        Equipo e = null;
        HttpSession sesion = request.getSession();
        ArrayList<Equipo> equipos=(ArrayList)sesion.getAttribute("equipos");
        if(equipos!=null){
            for (Equipo equipo: equipos) {
               if(equipo.getCodigo().equalsIgnoreCase(getInt("codigo",request))){
               
                   e = equipo;
                   
               }
            }
        }
        
        return e;
    }
    private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }
}

