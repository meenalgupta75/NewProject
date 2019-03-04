package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAOImpl;

/**
 * Servlet Filter implementation class Loginfilter
 */
@WebFilter("/Loginfilter")
public class Loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Loginfilter() {
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
		PrintWriter out=response.getWriter();
		LoginDAOImpl lb=new LoginDAOImpl();
		String password=request.getParameter("password");
		String user=request.getParameter("username");
		
		boolean flag=false;
		
		
		try{
			flag=lb.validateUser(user, password);
			
				
			
			if(flag==true)
			{
				//HttpSession session=request.getSession();
				//session.setAttribute("username", user);
				
				HttpSession session=((HttpServletRequest) request).getSession(true);
				session.setAttribute("username", user);
				
				
				
				RequestDispatcher rd=request.getRequestDispatcher("/ProductControler");
				rd.forward(request, response);
				chain.doFilter(request, response);
			}
			else{
				out.println("<meta http-equiv='refresh'content='1;URL=index.jsp'>");
				out.println("<center><p  style='font-size:200%'>Username or password is incorrect!</p></center>");
				
			
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
