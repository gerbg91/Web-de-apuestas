
package Presentation.Command;

import BLL.CuponBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
* @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera la lista de los numeros en la BD
 */
@WebServlet(name = "ListaNumerosCuponCommand", urlPatterns = {"/ListaNumerosCuponCommand"})
public class ListaNumerosCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          CuponBLL _listaNumerosBLL = new CuponBLL();  
          request.setAttribute("_listaNumeros", _listaNumerosBLL.listaNumeros());
        return "/ListaResultadosCupon.jsp";
    }
}
