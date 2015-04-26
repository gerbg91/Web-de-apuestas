
package Presentation.Command;

import BLL.NinoBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger Servlet que accede a la logica de negocio BLL Recupera el
 * resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarNinoEditarCommand", urlPatterns = {"/InsertarNinoEditarCommand"})
public class InsertarNinoEditarCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        NinoBLL _ninoBLL = new NinoBLL();       
            String _id_Nino = (request.getParameter("editar"));
           request.setAttribute("_datosNumero", _ninoBLL.editarNumeroBLL(_id_Nino));
        return "/InsertarNinoEditar.jsp";
    }
}