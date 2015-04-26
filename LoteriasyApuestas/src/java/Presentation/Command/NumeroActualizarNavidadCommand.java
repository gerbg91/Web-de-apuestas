
package Presentation.Command;

import BLL.NavidadBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera el resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "NumeroActualizarCommand", urlPatterns = {"/NumeroActualizarCommand"})
public class NumeroActualizarNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          
             NavidadBLL _navidadBLL = new NavidadBLL();
            String _numero_navidad = request.getParameter("numeroDado");
            String _tipo_loteria = request.getParameter("TipoLoteria");
            float _premio = Float.parseFloat(request.getParameter("premios"));
            String _fecha = request.getParameter("ingreso");
            String _id = request.getParameter("id_Navidad");
           _navidadBLL.actualizarNumeroBLL(_numero_navidad, _premio, _fecha, _tipo_loteria, _id);  
        return "/PrincipalBackend.jsp";
    }
}