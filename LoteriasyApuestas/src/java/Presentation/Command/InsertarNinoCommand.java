
package Presentation.Command;

import BLL.NinoBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera el resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarNinoCommand", urlPatterns = {"/InsertarNinoCommand"})
public class InsertarNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          
            String _numero_nino = request.getParameter("numeroDado");
            String _tipo_loteria = request.getParameter("TipoLoteria");
            float _premio = Float.parseFloat(request.getParameter("premios"));
            String _fecha = request.getParameter("ingreso");
            NinoBLL _ninoBLL = new NinoBLL();
            _ninoBLL.insertarNumeroBLL(_numero_nino, _premio, _fecha, _tipo_loteria);
        return "/PrincipalBackend.jsp";
    }
}
