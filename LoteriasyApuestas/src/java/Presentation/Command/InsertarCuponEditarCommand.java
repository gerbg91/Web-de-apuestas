
package Presentation.Command;

import BLL.CuponBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger Servlet que accede a la logica de negocio BLL Recupera el
 * resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarCuponEditarCommand", urlPatterns = {"/InsertarCuponEditarCommand"})
public class InsertarCuponEditarCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CuponBLL _cuponBLL = new CuponBLL();       
            String _id_cupon = (request.getParameter("editar"));
           request.setAttribute("_datosNumero", _cuponBLL.editarNumeroBLL(_id_cupon));
        return "/InsertarCuponEditar.jsp";
    }
}