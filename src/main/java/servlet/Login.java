package servlet;

import java.io.*;
import java.io.File;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.Exception;
import java.net.URI;

/**
 * Servlet implementation class Poblaciones
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
    private String dbPath;
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        try {
            URI dbUri = Login.class.getResource("/p5.sqlite").toURI();
            dbPath = new File(dbUri).getAbsolutePath();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String login, String password) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            Statement statement = connection.createStatement();
            String queryStr = "select 1 from user where login = '" + login + "' and password = '" + password + "'";
            ResultSet rs = statement.executeQuery(queryStr);
            result = rs.next() ? true : false;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (!authenticate(login, password)) {
            request.setAttribute("error", "Nombre de usuario o secreto invalido");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        else {
            request.getSession();
            response.sendRedirect("/");
        }
    }
}
