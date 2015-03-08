
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
        
        /*Recuperamos el numero de navidad dado por el usuario y el dinero jugado*/  
        int _numero_nino = Integer.parseInt(request.getParameter("numeroDado"));
        float _cantidad_jugada = Float.parseFloat(request.getParameter("cantidadDinero"));
        String _fecha = request.getParameter("fecha");
        NinoBLL _ninoBLL=new NinoBLL();
        request.setAttribute("Premio", _ninoBLL.comprobarNumeroBLL(_numero_nino,_cantidad_jugada, _fecha));
        return "/Resultado.jsp";
    }
}