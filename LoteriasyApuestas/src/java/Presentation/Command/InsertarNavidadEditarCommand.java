
package Presentation.Command;

import BLL.NavidadBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger Servlet que accede a la logica de negocio BLL Recupera el
 * resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarNavidadEditarCommand", urlPatterns = {"/InsertarNavidadEditarCommand"})
public class InsertarNavidadEditarCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        NavidadBLL _navidadBLL = new NavidadBLL();       
            String _id_Navidad = (request.getParameter("editar"));
           request.setAttribute("_datosNumero", _navidadBLL.editarNumeroBLL(_id_Navidad));
        return "/InsertarNavidadEditar.jsp";
    }
}
