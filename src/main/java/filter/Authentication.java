package filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Authentication implements Filter {
    public void  init(FilterConfig config) throws ServletException{
    }

    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws java.io.IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getRequestURI().startsWith("/Login") ||
                req.getRequestURI().startsWith("/Error")) {
            chain.doFilter(request, response);
            return;
        }

        boolean authenticated = req.getSession().getAttribute("user") != null;
        if(!authenticated){
            res.sendRedirect("/Login");
        }
        else{
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
