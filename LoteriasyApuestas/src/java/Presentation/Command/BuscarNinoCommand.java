
package Presentation.Command;

import BLL.NavidadBLL;
import BLL.NinoBLL;
import Entidades.Navidad;
import Entidades.Nino;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 * Servlet que accede a la logica de negocio BLL Recupera el
 * resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "BuscarNinoCommand", urlPatterns = {"/BuscarNinoCommand"})
public class BuscarNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Nino> _listaNumeros = null;
        int _numero_busqueda = Integer.parseInt(request.getParameter("buscar"));
        NinoBLL _ninoBLL = new NinoBLL();
        _listaNumeros = _ninoBLL.buscarNumeroBLL(_numero_busqueda);
       request.setAttribute("NumerosBuscados", _listaNumeros);
            return "/InsertarNino.jsp";
       

    }
}
