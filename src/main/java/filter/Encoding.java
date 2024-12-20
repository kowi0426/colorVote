package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Encoding
 */
@WebFilter("/*")
public class Encoding extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Encoding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#doFilter(HttpServletRequest, HttpServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

}
