
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
@WebServlet(name = "ResultadoNinoCommand", urlPatterns = {"/ResultadoNinoCommand"})
public class ResultadoNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String _numero_nino = request.getParameter("numeroDado");
        float _cantidad_jugada = Float.parseFloat(request.getParameter("cantidadDinero"));
        String _fecha = request.getParameter("ingreso");
        NinoBLL _ninoBLL=new NinoBLL();
        request.setAttribute("Premio", _ninoBLL.comprobarNumeroBLL(_numero_nino,_cantidad_jugada, _fecha));
        return "/Resultado.jsp";
    }
}