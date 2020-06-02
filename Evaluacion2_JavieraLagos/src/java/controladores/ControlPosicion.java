
package controladores;


import Entidades.Posicion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControlPosicion", urlPatterns = {"/ControlPosicion"})
public class ControlPosicion extends HttpServlet {

    private ArrayList posiciones;

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
           Posicion p  = new Posicion (getString("codigo",request),getString("nombre",request));
            ArrayList<Posicion> posiciones;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("posiciones")!=null){
                posiciones = (ArrayList) sesion.getAttribute("posiciones");
            }else{
                posiciones = new ArrayList();
            }
            posiciones.add(p);
            sesion.setAttribute("posiciones", posiciones);
            response.sendRedirect("intranet.jsp?mensaje=Posicion registrado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo ya existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Posicion antiguo = validar(request);
        if(antiguo !=null){
            antiguo.setNombre(getString("nombre",request));
           
            response.sendRedirect("intranet.jsp?mensaje=Posicion Modificado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Posicion no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Posicion antiguo = validar(request);
        if(antiguo!=null){
            ArrayList<Posicion> posicions ;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("posicion")!=null){
               posiciones = (ArrayList) sesion.getAttribute("posiciones");
            }else{
                posiciones= new ArrayList();
            }
            posiciones.remove(antiguo);
            sesion.setAttribute("posiciones", posiciones);
            response.sendRedirect("intranet.jsp?mensaje=Posicion Eliminado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    
    private Posicion validar(HttpServletRequest request){
        Posicion p = null;
        HttpSession sesion = request.getSession();
        ArrayList<Posicion> equipos=(ArrayList)sesion.getAttribute("posiciones");
        if(posiciones!=null){
            for (Posicion posicion : posiciones) {
                if(posicion.getCodigo().equalsIgnoreCase(getString("codigo",request))){
                
                    p = posicion;
                }
            }
        }
        
        return p;
    }
    private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }
}

