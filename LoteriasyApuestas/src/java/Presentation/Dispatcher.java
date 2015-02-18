/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ger
 */
public class Dispatcher {
    public void procesa (HttpServletRequest request, HttpServletResponse response,String nextPage) throws ServletException, IOException {
            response.setContentType("text/html;charset-UTF-8");
            request.setAttribute("paginaprincipal", nextPage);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
