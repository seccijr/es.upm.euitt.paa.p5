package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Set;
import java.util.SortedSet;
import javax.servlet.*;
import javax.servlet.http.*;
import paa.provincias.IPoblacion;
import paa.provincias.IAlmacenPoblaciones;
import paa.provincias.IPoblacionAEMET;
import model.Provincia;
import model.ListaPoblaciones;
import model.ListaProvincias;
import almacen.AlmacenPoblaciones;
import java.net.URISyntaxException;
import java.net.URI;

/**
 * Servlet implementation class Poblaciones
 */
@SuppressWarnings("serial")
public class PoblacionesDeleteAll extends HttpServlet {
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        almacen.recuperar(almacenPath);
        String provincia = request.getParameter("provincia");
        almacen.delProvincia(provincia);
        almacen.addProvincia(provincia);
        almacen.guardar(almacenPath);
        response.sendRedirect("/Poblaciones?provincia=" + provincia);
    }
}
