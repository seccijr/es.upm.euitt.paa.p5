package servlet;

import java.io.IOException;
import java.io.File;
import javax.servlet.*;
import javax.servlet.http.*;
import paa.provincias.IAlmacenPoblaciones;
import almacen.AlmacenPoblaciones;
import almacen.Poblacion;
import java.net.URISyntaxException;
import java.net.URI;

/**
 * Servlet implementation class Poblaciones
 */
@SuppressWarnings("serial")
public class PoblacionesAdd extends HttpServlet {
    private IAlmacenPoblaciones almacen = null;
    private String almacenPath = null;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        almacen = new AlmacenPoblaciones();
        try {
            URI almacenUri = Poblaciones.class.getResource("/almacen.dat").toURI();
            almacenPath = new File(almacenUri).getAbsolutePath();
        }
        catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        almacen.recuperar(almacenPath);
        request.setAttribute("provincia", request.getParameter("provincia"));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Poblaciones/add.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        almacen.recuperar(almacenPath);
        String nombre = request.getParameter("nombre");
        String provincia = request.getParameter("provincia");
        int habitantes = Integer.parseInt(request.getParameter("habitantes"));
        String codigo = request.getParameter("codigo");
        Poblacion poblacion = new Poblacion(nombre, provincia, habitantes, codigo);
        almacen.addPoblacion(provincia, poblacion);
        almacen.guardar(almacenPath);
        response.sendRedirect("/Poblaciones?provincia=" + provincia);
    }
}
