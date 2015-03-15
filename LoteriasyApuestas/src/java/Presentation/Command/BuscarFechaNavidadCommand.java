package Presentation.Command;

import BLL.NavidadBLL;
import Entidades.Navidad;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet que accede a la logica de negocios y a busca los numeros por fecha
 * 
 * @author Ger 
 */
@WebServlet(name = "BuscarFechaNavidadCommand", urlPatterns = {"/BuscarFechaCommand"})
public class BuscarFechaNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Navidad> _listaNumeros = null;
        String _fecha = request.getParameter("fecha");
        NavidadBLL _navidadBLL = new NavidadBLL();
        _listaNumeros = _navidadBLL.buscarNumeroByFechaBLL(_fecha);
        request.setAttribute("NumerosBuscados", _listaNumeros);
        return "/InsertarNavidad.jsp";

    }
}
