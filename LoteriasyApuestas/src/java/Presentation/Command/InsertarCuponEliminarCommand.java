
package Presentation.Command;

import BLL.CuponBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera el resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarCuponEliminarCommand", urlPatterns = {"/InsertarCuponEliminarCommand"})
public class InsertarCuponEliminarCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CuponBLL _cuponBLL = new CuponBLL();
           String _id_Cupon = (request.getParameter("eliminar"));
           _cuponBLL.eliminarNumeroBLL(_id_Cupon);
        return "/PrincipalBackend.jsp";
    }
}
