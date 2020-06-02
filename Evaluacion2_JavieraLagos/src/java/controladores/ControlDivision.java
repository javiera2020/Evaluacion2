
package controladores;


import Entidades.Division;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControlDivision", urlPatterns = {"/ControlDivision"})
public class ControlDivision extends HttpServlet {

    private Iterable<Division> divisiones;

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
            Division d  = new Division (getInt("codigo",request),getString("nombre",request));
            ArrayList<Division> divisiones;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("divisiones")!=null){
                divisiones = (ArrayList) sesion.getAttribute("divisiones");
            }else{
                divisiones = new ArrayList();
            }
            divisiones.add(d);
            sesion.setAttribute("divisiones", divisiones);
            response.sendRedirect("intranet.jsp?mensaje=Division registrado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo ya existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Division antiguo = validar(request);
        if(antiguo !=null){
            antiguo.setNombre(getString("nombre",request));
           
            response.sendRedirect("intranet.jsp?mensaje=Division Modificado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Division no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Division antiguo = validar(request);
        if(antiguo!=null){
            ArrayList<Division> divisiones ;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("divisiones")!=null){
               divisiones = (ArrayList) sesion.getAttribute("divisiones");
            }else{
                divisiones= new ArrayList();
            }
            divisiones.remove(antiguo);
            sesion.setAttribute("divisiones", divisiones);
            response.sendRedirect("intranet.jsp?mensaje=Division Eliminado");
        }else{
            response.sendRedirect("intranet.jsp?mensaje=Codigo no existe");
        }
         } catch (Exception e) {
                response.sendRedirect("intranet.jsp?mensaje="+e.getMessage());
            }
    }
    
    private Division validar(HttpServletRequest request){
       Division d = null;
        HttpSession sesion = request.getSession();
        ArrayList<Division> equipos=(ArrayList)sesion.getAttribute("divisiones");
        if(equipos!=null){
            for (Division division: divisiones) {
               if(division.getCodigo().equalsIgnoreCase(getString("codigo",request))){
               
                   d = division;
                }
            }
        }
        
        return d;
    }
    private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }
}
