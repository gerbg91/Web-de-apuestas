
package Presentation.Command;

import BLL.NavidadBLL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 * Servlet que accede a la logica de negocio BLL
 * Recupera el resultado del numero dado o la apuesta hecha en la BD
 */
@WebServlet(name = "InsertarNavidadCommand", urlPatterns = {"/InsertarNavidadCommand"})
public class InsertarNavidadCommand extends ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
          
        int _numero_navidad = Integer.parseInt(request.getParameter("numeroDado"));
        String _tipo_loteria = request.getParameter("TipoLoteria");
        float _premio = Float.parseFloat(request.getParameter("cantidadDinero"));
        String _fecha = request.getParameter("fecha");
         String _opcion = request.getParameter("opcion");
        NavidadBLL _navidadBLL=new NavidadBLL();
      
        if(_opcion.equalsIgnoreCase("anadir")){
          _navidadBLL.insertarNumeroBLL(_numero_navidad,_premio,_fecha,_tipo_loteria);
        }else {
           _navidadBLL.eliminarNumeroBLL(_numero_navidad,_premio,_fecha,_tipo_loteria); 
        }
        return "/InsertarNavidad.jsp";
    }
}