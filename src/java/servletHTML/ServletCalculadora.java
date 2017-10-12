/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletHTML;

/**
 *
 * @author Alumno
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ServletCalculadora extends HttpServlet{
    double result;
    
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        String texto = peticion.getParameter("op");
        if(texto.equals("suma") || texto.equals("Suma")){
            result = Double.parseDouble(peticion.getParameter("num1")) + Double.parseDouble(peticion.getParameter("num2"));
        }
        if(texto.equals("resta") || texto.equals("Resta")){
            result = Double.parseDouble(peticion.getParameter("num1")) - Double.parseDouble(peticion.getParameter("num2"));
        }
        if(texto.equals("multiplicacion") || texto.equals("Multiplicacion")){
            result = Double.parseDouble(peticion.getParameter("num1")) * Double.parseDouble(peticion.getParameter("num2"));
        }
        if(texto.equals("division") || texto.equals("Division")){
            result = Double.parseDouble(peticion.getParameter("num1")) / Double.parseDouble(peticion.getParameter("num2"));
        }
        respuesta.setContentType("text/html");
        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Resultado</title></head>");
        out.println("<body>");
        out.println("<p>El resultado es:" + result +"</p>");
        out.println("</body></html>");
        out.close();
    }
}
