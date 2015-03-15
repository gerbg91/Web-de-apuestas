
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
@WebServlet(name = "InsertarCuponCommand", urlPatterns = {"/InsertarCuponCommand"})
public class InsertarCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String _opcion = request.getParameter("opcion");
        CuponBLL _cuponBLL = new CuponBLL();

        if (_opcion.equalsIgnoreCase("anadir")) {
            String _numero_cupon = request.getParameter("numeroDado");
            String _tipo_loteria = request.getParameter("TipoLoteria");
            float _premio = Float.parseFloat(request.getParameter("cantidadDinero"));
            String _fecha = request.getParameter("fecha");
            _cuponBLL.insertarNumeroBLL(_numero_cupon, _premio, _fecha, _tipo_loteria);
        } else {
            String _fecha = request.getParameter("fecha");
            String _tipo_loteria = request.getParameter("TipoLoteria");
            String _numero_cupon = request.getParameter("numeroDado");
            _cuponBLL.eliminarNumeroBLL(_numero_cupon, _fecha);
        }
        return "/InsertarCupon.jsp";
    }
}
