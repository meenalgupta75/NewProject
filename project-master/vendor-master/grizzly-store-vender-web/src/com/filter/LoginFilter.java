package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.dao.LoginDAOImpl;
import com.model.Login;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
		LoginDAOImpl lb=new LoginDAOImpl(); 
		
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean flag=false;
		try {
			flag=lb.validateUser(user, password);
			if(flag==true){
				
				
					lb.resetUserStatus(user);
					HttpSession session=((HttpServletRequest)request).getSession(true);
					session.setAttribute("username",user);
				
					RequestDispatcher rd=request.getRequestDispatcher("/ProductController");
					Login profile = lb.userDetails(user);
					
					session.setAttribute("user", profile );
					session.setAttribute("type", "admin" );
					rd.forward(request, response);
				
				//System.out.println("htt");
				
				chain.doFilter(request, response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				}
			}

	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
