package lunch.hour.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Heron Sanches
 */
@WebFilter(filterName = "LoginF", urlPatterns = {"/*"})
public class LoginF implements Filter {

   // The filter configuration object we are associated with.  If
   // this value is null, this filter instance is not currently
   // configured. 
   private FilterConfig filterConfig = null;

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse resp = (HttpServletResponse) response;
      String loginEmail = (String) req.getSession().getAttribute("loginEmail");
      String url = req.getRequestURI();

      if (loginEmail == null) {

         if (url.contains("/lunch")) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/login");
         } else {
            chain.doFilter(request, response);
         }

      } else if (url.contains("/login") || url.contentEquals("/")) {
         resp.sendRedirect(req.getServletContext().getContextPath() + "/lunch");
      } else {
         chain.doFilter(request, response);
      }

   }

   @Override
   public void destroy() {

   }

}
