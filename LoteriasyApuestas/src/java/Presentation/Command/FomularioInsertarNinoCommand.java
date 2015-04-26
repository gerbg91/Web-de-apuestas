
package Presentation.Command;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger Servlet que accede a la logica de negocio BLL Recupera el
 * resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "FomularioInsertarNinoCommand", urlPatterns = {"/FomularioInsertarNinoCommand"})
public class FomularioInsertarNinoCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {      
        return "/AgregarNino.jsp";
    }
}
