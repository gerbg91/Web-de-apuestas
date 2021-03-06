
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
@WebServlet(name = "NumeroActualizarCuponCommand", urlPatterns = {"/NumeroActualizarCuponCommand"})
public class NumeroActualizarCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          
            CuponBLL _cuponBLL = new CuponBLL();
            String _numero_cupon = request.getParameter("numeroDado");
            String _tipo_loteria = request.getParameter("TipoLoteria");
            float _premio = Float.parseFloat(request.getParameter("premios"));
            String _fecha = request.getParameter("ingreso");
            String _id = request.getParameter("id_Cupon");
           _cuponBLL.actualizarNumeroBLL(_numero_cupon, _premio, _fecha, _tipo_loteria, _id);  
        return "/PrincipalBackend.jsp";
    }
}