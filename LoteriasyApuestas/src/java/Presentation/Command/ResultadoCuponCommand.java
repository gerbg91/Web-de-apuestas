
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
@WebServlet(name = "ResultadoCuponCommand", urlPatterns = {"/ResultadoCuponCommand"})
public class ResultadoCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String _numero_cupon = request.getParameter("numeroDado");
        String _numero_serie = request.getParameter("serieDado");
        String _fecha = request.getParameter("ingreso");
        CuponBLL _cuponBLL=new CuponBLL();
        request.setAttribute("Premio", _cuponBLL.comprobarNumeroBLL(_numero_cupon,_numero_serie, _fecha));
        return "/Resultado.jsp";
    }
}