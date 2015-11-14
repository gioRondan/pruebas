
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataInfoProveedor;

/**
 *
 * @author giovani
 */
@WebServlet(urlPatterns = {"/login"})
public class inicioSesion extends HttpServlet {

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
        servidor.PublicadorProveedorService service = new servidor.PublicadorProveedorService();
        servidor.PublicadorProveedor port = service.getPublicadorProveedorPort();
        
        if ((request.getSession().getAttribute("Login") == "Logeado")){
            
             request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
        }
        else{
            if(request.getParameter("entrar") != null){
               String nick = (String) request.getParameter("nick");
               String pass = (String) request.getParameter("pass");
               DataInfoProveedor cliente = port.iniciarSesion(nick, pass);
               
               if(cliente != null){
                   request.getSession().setAttribute("dataProveedor", cliente);
                   request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
                   request.getSession().setAttribute("Login", "Logeado");
               }else{
                   request.getSession().setAttribute("Login", "Datosincorrectos");
                   request.getRequestDispatcher("/WEB-INF/inicioSesion.jsp").forward(request, response); 
               }
            }else{

              request.getRequestDispatcher("/WEB-INF/Usuarios/inicioSesion.jsp").forward(request, response);  
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
