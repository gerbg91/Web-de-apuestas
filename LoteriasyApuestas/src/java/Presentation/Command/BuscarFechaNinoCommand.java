package Presentation.Command;

import BLL.NinoBLL;
import Entidades.Nino;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Accede a la logica de negocio y recupera una lista de numeros por fecha
 *
 * @author Ger
 */
@WebServlet(name = "BuscarFechaNinoCommand", urlPatterns = {"/BuscarFechaNinoCommand"})
public class BuscarFechaNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Nino> _listaNumeros = null;
        String _fecha = request.getParameter("fecha");
        NinoBLL _ninoBLL = new NinoBLL();
        _listaNumeros = _ninoBLL.buscarNumeroByFechaBLL(_fecha);
        request.setAttribute("NumerosBuscados", _listaNumeros);
        return "/InsertarNino.jsp";

    }
}
