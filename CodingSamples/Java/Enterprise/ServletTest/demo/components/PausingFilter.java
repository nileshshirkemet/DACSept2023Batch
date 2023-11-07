package components;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class PausingFilter implements Filter {
    
    private long recent = 0;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain next) throws IOException, ServletException {
        long current = System.currentTimeMillis();
        if(current - recent > 3000){
            next.doFilter(req, res);
            recent = current;
        }else{
            var out = res.getWriter();
            out.println("Server is busy, please try after some time...");
        }
    }
}
