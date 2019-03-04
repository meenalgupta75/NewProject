<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import ="java.util.*" %>
    <%@ page import="com.model.Product" %>
    <%@ page import="com.model.Login" %>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
   
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
         
         <script type="text/javascript">
function handleSelect(elm)
{
window.location = elm.value;
}
</script>
</head>
<body>
<%Login details=(Login)session.getAttribute("user"); %>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
                <img src="images/smlogo.png"></img>
                                 
                    <form class="mx-2 my-auto d-inline w-20">
                        <div class="input-group">
                            <input type="text" class="form-control form-rounded border border-right-0" placeholder="Search...">
                            <span class="input-group-append">
                            <button class="btn btn-outline-secondary border border-left-0" type="button">
                                <i class="fa fa-search"></i>                              
                            </button>
                          </span>
                        </div>
                    </form>

               <ul class="navbar-nav ml-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#"><span class="fa fa-bell"></span></a>
                   </li>
                   <li class="nav-item">
                       <span class="navbar-text">
                           Welcome,<% out.print(details.getName());%>
                       </span>
                   </li>
                   </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <form class="mx-2 my-auto w-full">
                                <a href="Logout.jsp" class="btn btn-secondary  form-rounded" >Logout
           
            </a>
                            </form>
                        </li>
                    </ul>
                        
            </nav>

<div class="container-fluid">
<br>
    <div class="row">
            <div class="col-md-3 bg-light">
                <nav class="navbar navbar-expand-md navbar-dark bg-secondary">
                    <span class="navbar-text navbar-">PROFILE</span>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a href="" style="color: aliceblue">Edit</a>
                        </li>
                    </ul>
                </nav>

<br><center>
    <picture>
        <img src="images/profile.png" alt="Profile picture" width="50px"></img>
    </picture><br>
    <input id="prodId" name="userId" type="hidden" value="<%=details.getId() %>">
    <b><% out.print(details.getName());%></b>
<br><br>
ID: <br> <% out.print(details.getId());%>
<br><br>
Designation:<br>
<% out.print(details.getDesgination());%>
<br><br>
<address>
        Office:<br>
        <% out.print(details.getOffice());%>
</address>
</center>
  </div>

                <div class="col-md-9 bg-light">
            
                    <div class="btn-group col-md-12">
                        <div class="container">
                            
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                              <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#menu1">INVENTORY</a>
                              </li>
                            
                            </ul>
                          
                            <!-- Tab panes -->
                            <div class="tab-content">
                              <div id="home" class="container tab-pane active"><br>
        
                        <div class="col-md-12 bg-light">
                                <form class="mx-2 my-auto d-inline w-20" action="" method="POST">
                                        <div class="input-group">
                                            <input list="category" name="browser" class="form-rounded" placeholder="Choose Action">
                                            <datalist id="category">
                                              <option value="Personal Care" selected>
                                              <option value="Laptops">
                                              <option value="Art Supplies">
                                             </datalist>    


                                                    &emsp;&nbsp;&nbsp;
                                                    <input type="text" name="category" class="form-rounded border border-right-0" placeholder="Category Name">
                                                    <span class="input-group-append">
                                                    <button class="btn btn-outline-secondary border border-left-0" type="submit">
                                                        <i class="fa fa-search"></i>                              
                                                    </button>
                                                  </span>

                                                  &emsp;&emsp;
                                                      
  &emsp;&emsp;&emsp;&emsp;&emsp;
</form>
		
<form action="inventory.jsp">
                        </div>
    
                                     <br>     <br>                
                                     <table border="1" class="table table-bordered table-striped">
                                     <thead>
                                            <tr>
                                                <td>
                                                    <center><span style="color: gray">Name</span>
                                                </td>
                                                <td>
                                                        <center> <span style="color: gray">Category</span>
                                                    </td>
                                                    <td>
                                                            <center><span style="color: gray">ID</span>
                                                        </td>
                                                        <td>
                                                                <center><span style="color: gray">Price</span>
                                                            </td>
                                                        <td>

</td>
                                                           
                                            </tr>
                                            </thead>
						<% ArrayList<Product> pro= (ArrayList)request.getAttribute("product"); %>
                       
						<%for(Product p:pro){ %>

                        <tr>
                          <td>
<div class="checkbox checkbox-info checkbox-circle">
                              <input id="checkbox11" type="checkbox" >
                              <label for="checkbox11">
                            
                             <% out.print(p.getProduct_name());%>
  </label>
                            </div>  

                          </td>
                          <td>
                             <% out.print(p.getCategory());%>
                          </td>
                          <td>
                             <% out.print(p.getProduct_id());%>
                          </td>
                          <td>
                           <% out.print(p.getPrice());%>
                          </td>
                          
                          <td>
                            <center>
                              <a href="view?product_id=<%=p.getProduct_id()%>" class="btn btn-secondary form-rounded"  width="50px"> &emsp;View&emsp; 
                              </a>
                             
                              <a href="delete?product_id=<%=p.getProduct_id()%>"class="btn btn-secondary form-rounded">&nbsp;delete&nbsp; 
                              </a>
                            </center>
                          </td>
                        </tr>
                      <%} %>     
                         

                                        </table>

                        </div>
               
                              </div>
                              <div id="menu1" class="container tab-pane fade"><br>
                                <p>
                                    VENDOR SIDE
                                    </p>
                              </div>
                            </div>
                          </div>
                    </div>
                    <br>
    </div>    

           
</body>
</html>