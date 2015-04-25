
package Presentation.Command;

import BLL.NavidadBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
* @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera la lista de los numeros en la BD
 */
@WebServlet(name = "ListaNumerosNavidadCommand", urlPatterns = {"/ListaNumerosNavidadCommand"})
public class ListaNumerosNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          NavidadBLL _listaNumerosBLL = new NavidadBLL();  
          request.setAttribute("_listaNumeros", _listaNumerosBLL.listaNumeros());
        return "/ListaResultadosNavidad.jsp";
    }
}
