
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
          
        int _numero_nino = Integer.parseInt(request.getParameter("numeroDado"));
        String _tipo_loteria = request.getParameter("TipoLoteria");
        float _premio = Float.parseFloat(request.getParameter("cantidadDinero"));
        String _fecha = request.getParameter("fecha");
        NinoBLL _ninoBLL=new NinoBLL();
        request.setAttribute("Premio", _ninoBLL.insertarNumeroBLL(_numero_nino,_premio,_fecha,_tipo_loteria));
        return "/index.jsp";
    }
}