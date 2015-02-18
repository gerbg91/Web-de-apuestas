
package Presentation.Command;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class ICommand {

    public void initPage (HttpServletRequest request, HttpServletResponse response){
        
    }
    public abstract String execute (HttpServletRequest request, HttpServletResponse response) throws Exception;

    void init(ServletConfig config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
