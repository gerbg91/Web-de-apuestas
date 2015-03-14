package Presentation.Command;

import BLL.AdminBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger Servlet que accede a la logica de negocio BLL Entrada de login
 */
@WebServlet(name = "EntradaCommand", urlPatterns = {"/EntradaCuponCommand"})
public class EntradaCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String _usuario = (request.getParameter("usuario"));
        String _password = (request.getParameter("password"));
        AdminBLL _adminBLL = new AdminBLL();
        boolean _verificacion = _adminBLL.comprobarUsuarioBLL(_usuario, _password);
        if (_verificacion) {
            return "/InsertarCupon.jsp";
        } else {
            return "/login.jsp";
        }
    }
}
