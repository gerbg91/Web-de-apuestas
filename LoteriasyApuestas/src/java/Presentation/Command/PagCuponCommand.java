
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
@WebServlet(name = "PagCuponCommand", urlPatterns = {"/PagCuponCommand"})
public class PagCuponCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
         CuponBLL _listaNumerosBLL = new CuponBLL();  
          request.setAttribute("_listaNumeros", _listaNumerosBLL.listaNumeros_admin());
        return "/InsertarCupon.jsp";
    }
}