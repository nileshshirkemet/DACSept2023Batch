package shopping;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

//web-browser only permits the code running within its context to
//consume resources from the endpoint from which that code originated
//(same origin policy) or from an endpoint which has enabled 
//cross origin resource sharing (CORS) policy

@WebFilter("/api/sales/*")
public class UseCORSFilter implements Filter {
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain next) throws IOException, ServletException {
        var response = (HttpServletResponse) res;
        response.addHeader("ACCESS-CONTROL-ALLOW-ORIGIN", "*");
        response.addHeader("ACCESS-CONTROL-ALLOW-METHODS", "*");
        response.addHeader("ACCESS-CONTROL-ALLOW-HEADERS", "*");
        next.doFilter(req, res);
    }
}
