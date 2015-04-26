package Presentation.Command;

import BLL.NinoBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
* @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera la lista de los numeros en la BD
 */
@WebServlet(name = "PagNinoCommand", urlPatterns = {"/PagNinoCommand"})
public class PagNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          NinoBLL _listaNumerosBLL = new NinoBLL();  
          request.setAttribute("_listaNumeros", _listaNumerosBLL.listaNumeros());
        return "/InsertarNino.jsp";
    }
}