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
@WebServlet(name = "BuscarCuponCommand", urlPatterns = {"/BuscarCuponCommand"})
public class BuscarCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Cupon> _listaNumeros = null;
        int _numero_busqueda = Integer.parseInt(request.getParameter("buscar"));
        CuponBLL _cuponBLL = new CuponBLL();
        _listaNumeros = _cuponBLL.buscarNumeroBLL(_numero_busqueda);
        request.setAttribute("NumerosBuscados", _listaNumeros);
        return "/InsertarCupon.jsp";

    }
}
