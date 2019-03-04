package com.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAOImpl;
import com.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductControler
 */
@WebServlet("/ProductControler")
public class ProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductServiceImpl p;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductControler() {
        super();
        // TODO Auto-generated constructor stub
    }
 

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		p=new ProductServiceImpl();
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
	     String action=request.getServletPath();
	     switch(action)
	     {
	     case "/ProductControler" :
	    	 try {
				p.getproduct(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	 break;
	     case "/addproduct":
	    	 try {
	    		 
				p.Addnewproduct(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 break;
	     case "/delete" :
	    	 try{
	    		 p.deleteproduct(request,response);
	    	 }catch (SQLException e) {
				// TODO: handle exception
	    		 e.printStackTrace();
			}
	    	 break;
	     case "/view" :
	    	 try{
	    		 p.viewproduct(request,response);
	    	 }catch(SQLException e){
	    		 e.printStackTrace();
	    	 }
	     
	    break;
	    case "/sort" :
	    	try{
	    		 p.viewproduct(request,response);
	    	 }catch(SQLException e){
	    		 e.printStackTrace();
	    	 }
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
