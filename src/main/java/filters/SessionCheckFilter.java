package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SessionCheckFilter")
public class SessionCheckFilter implements Filter {

    private String contextPath;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        contextPath = fc.getServletContext().getContextPath();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();


        User userLogOn = (User) session.getAttribute("userTryLogin");
        System.out.println("print user from session filter - userTryLogin : " + userLogOn);
        String userRole = userLogOn.getRole();


        if (userRole.equals("admin")) {
            fc.doFilter(req, resp);
        } else if (userRole.equals("user")) {
            req.setAttribute("userLogOn", userLogOn);

            System.out.println("print user from session to USER - userLogOn : " + ((User) session.getAttribute("userLogOn")));

            session.setAttribute("userLogOn", userLogOn);

            System.out.println("print user from session to USER - userLogOn : " + ((User) session.getAttribute("userLogOn")));

            resp.sendRedirect("user");
        } else if (userRole == null) {
            req.getServletContext()
                    .getRequestDispatcher("/jsp/index.jsp")
                    .forward(req, resp);
        }

    }


    @Override
    public void destroy() {

    }


}










