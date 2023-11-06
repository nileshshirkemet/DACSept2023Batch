package components;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class GreetingServlet implements Servlet {

        private ServletConfig config;

        public void init(ServletConfig cfg) throws ServletException {
            config = cfg;
        }

        public void destroy() {

        }

        public ServletConfig getServletConfig() {
            return config;
        }

        public String getServletInfo() {
            return "Greeting Servlet";
        }

        public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            String name = request.getParameter("guest");
            if(name == null)
                name = "Visitor";
            response.setContentType("text/html");
            var out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>DemoApp</title></head>");
            out.println("<body>");
            out.printf("<h1>Welcome %s</h1>", name);
            out.printf("<b>Current Time: </b>%s%n", new Date());
            out.println("</body>");
            out.println("</html>");
        }



        
}
