package components;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class CountingServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("visitor");
        if(name.length() == 0){
            response.sendRedirect("welcome");
            return;
        }
        var session = request.getSession(true);
        Integer count = (Integer)session.getAttribute(name);
        if(count == null)
            count = 1;
        session.setAttribute(name, count + 1);
        response.setContentType("text/html");
        var out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>DemoApp</title></head>");
        out.println("<body>");
        out.printf("<h1>Hello %s</h1>%n", name);
        out.printf("<b>Number of Greetings: </b>%d%n", count);
        out.println("</body>");
        out.println("</html>");
        if(count >= 5)
            session.invalidate();
    }
}
