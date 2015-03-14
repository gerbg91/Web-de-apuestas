
package Presentation.Command;

import BLL.NavidadBLL;
import Entidades.Navidad;
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
@WebServlet(name = "BuscarNavidadCommand", urlPatterns = {"/BuscarNavidadCommand"})
public class BuscarNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Navidad> _listaNumeros = null;
        int _numero_busqueda = Integer.parseInt(request.getParameter("buscar"));
        NavidadBLL _navidadBLL = new NavidadBLL();
        _listaNumeros = _navidadBLL.buscarNumeroBLL(_numero_busqueda);
       request.setAttribute("NumerosBuscados", _listaNumeros);
            return "/InsertarNavidad.jsp";
       

    }
}
