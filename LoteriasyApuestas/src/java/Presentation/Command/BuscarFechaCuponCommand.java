package Presentation.Command;

import BLL.CuponBLL;
import Entidades.Cupon;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que accede a la logica de negocios y a busca los numeros por fecha
 * 
 * @author Ger 
 */
@WebServlet(name = "BuscarFechaCuponCommand", urlPatterns = {"/BuscarFechaCuponCommand"})
public class BuscarFechaCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Cupon> _listaNumeros = null;
        String _fecha = request.getParameter("fecha");
        CuponBLL _cuponBLL = new CuponBLL();
        _listaNumeros = _cuponBLL.buscarNumeroByFechaBLL(_fecha);
        request.setAttribute("NumerosBuscados", _listaNumeros);
        return "/InsertarCupon.jsp";

    }
}
