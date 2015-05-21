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
public class Poblaciones extends HttpServlet {
    private IAlmacenPoblaciones almacen = null;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        almacen = new AlmacenPoblaciones();
        try {
            URI almacenUri = Poblaciones.class.getResource("/almacen.dat").toURI();
            String almacenPath = new File(almacenUri).getAbsolutePath();
            almacen.recuperar(almacenPath);
        }
        catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Set<String> setProvincias = almacen.getProvincias();
        ListaProvincias listaProvincias = new ListaProvincias();
        for (String nombreProvincia: setProvincias) {
            int poblaciones = almacen.getNumPoblaciones(nombreProvincia);
            Provincia provincia = new Provincia(nombreProvincia, poblaciones);
            listaProvincias.addProvincia(provincia);
        }
        request.setAttribute("listaProvincias", listaProvincias);

        ListaPoblaciones listaPoblaciones = null;
        String provinciaParam = request.getParameter("provincia");
        if (provinciaParam != null && !provinciaParam.isEmpty()) {
            SortedSet<IPoblacion> poblaciones = almacen.getPoblaciones(provinciaParam);
            listaPoblaciones = new ListaPoblaciones(poblaciones, provinciaParam);
        }
        else {
            listaPoblaciones = new ListaPoblaciones();
        }
        request.setAttribute("listaPoblaciones", listaPoblaciones);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Poblaciones/listaProvincias.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
}
