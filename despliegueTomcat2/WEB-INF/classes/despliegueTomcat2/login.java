package despliegueTomcat2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class login extends HttpServlet {

    public void init(ServletConfig config)
	throws ServletException {

	super.init(config);
    }

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException 
    {
	// If it is a get request forward to doPost()
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request,
		       HttpServletResponse response)
	throws ServletException, IOException 
    {
	// Obtenemos el nombre de usuario a partir de la peticion
	String username = request.getParameter("username");
	// Obtenemos la contrasenha a partir de la peticion
	String password = request.getParameter("password");
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String docType =
	    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	    "Transitional//EN\">\n";
	out.println(docType +
		    "<HTML>\n" +
		    "<HEAD><TITLE>Bienvenido a DAW</TITLE></HEAD>\n" +
		    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<table align=\"center\" border=\"0\">" +
		    "<tr>" + 
		    "<th><IMG SRC=\"/despliegueTomcat2/imagenes/tomcat.gif\" ALIGN=\"CENTER\"></th>" +
		    "<th><H1>Bienvenido a DAA</H1></th>" +
		    "<th><IMG SRC=\"/despliegueTomcat2/imagenes/tomcat.gif\" ALIGN=\"CENTER\"></th>" +
		    "</tr>" +
		    "</table>" +
		    "\n\n" +
		    "<table align=\"center\" border=\"1\" cellpadding=\"1\" width=\"60%\" bgcolor=\"#FFFFFF\">" +
		    "<tr>" +
		    "<td><b>¡Menudo nombre tienes!</b></td>" +
		    "<td><b>¿Y andas con este password?</b></td>" +
		    "</tr>" +
		    "<tr>" +
		    "<td>" + username + "</td>" +
		    "<td>" + password + "</td>" +
		    "</tr>" +
		    "</table>" +
		    "<p>" +
		    "<center>" +
		    "<a HREF=\"/despliegueTomcat2/index.html\"> Volver a la pagina principal </a>" +
		    "</center>" +
		    "</BODY></HTML>");




    }

    public void destroy() 
    {
    }
}
