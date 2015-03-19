
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
@WebServlet(name = "ResultadoNavidadCommand", urlPatterns = {"/ResultadoNavidadCommand"})
public class ResultadoNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /*Recuperamos el numero de navidad dado por el usuario y el dinero jugado*/  
        String _numero_navidad =request.getParameter("numeroDado");
        float _cantidad_jugada = Float.parseFloat(request.getParameter("cantidadDinero"));
        String _fecha = request.getParameter("ingreso");
        NavidadBLL _navidadBLL=new NavidadBLL();
        request.setAttribute("Premio", _navidadBLL.comprobarNumeroBLL(_numero_navidad,_cantidad_jugada, _fecha));
        return "/Resultado.jsp";
    }
}