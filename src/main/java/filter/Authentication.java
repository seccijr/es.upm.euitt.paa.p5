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
        if (req.getRequestURI().startsWith("/Login")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        if(session == null){
            res.sendRedirect("/Login");
        }else{
            chain.doFilter(request, response);
            return;
        }
    }

    public void destroy() {
    }
}
