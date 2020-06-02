
package controladores;

import Entidades.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Ingreso", urlPatterns = {"/Ingreso"})
public class Ingreso extends HttpServlet {

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
        String usuario = request.getParameter("usuario").trim();
        String password = request.getParameter("password").trim();
        if(usuario.isEmpty()||password.isEmpty()){
            response.sendRedirect("index.jsp?mensaje=Complete todos los campos");
        }else{
            Usuario u = new Usuario();
            u.setUsuario(usuario);
            u.setPassword(password);
            ArrayList<Usuario> usuarios;
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("usuarios")!=null){
                usuarios = (ArrayList) sesion.getAttribute("usuarios");
            }else{
                usuarios = new ArrayList();
            }
            u = iniciarSesion(u,usuarios);
            if(u!=null){
                sesion.setAttribute("usuario", u);
                response.sendRedirect("intranet.jsp");
            }else{
                response.sendRedirect("index.jsp?mensaje=usuario o password invalido");
            }
        }
    }
    private Usuario iniciarSesion(Usuario u,ArrayList<Usuario> usuarios){
        Usuario temporal = null;
        for(Usuario usuario:usuarios){
            if(usuario.getUsuario().equalsIgnoreCase(u.getUsuario())&&
                    usuario.getPassword().equals(u.getPassword())){
                temporal = usuario;
            }
        }
        return temporal;
    }
}
