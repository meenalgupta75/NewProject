<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.model.Login" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" href="styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Product Add</title>
 <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
  <body>
  <%Login details=(Login)session.getAttribute("user"); %>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="images/smlogo.png" alt="logo">
      </a>
      <form class="mx-2 my-auto d-inline">
        <div class="input-group topnav1">
          <input type="text" class="form-control border border-right-0 bg-light form-rounded" placeholder="Search">
          <span class="input-group-append">
            <button class="btn btn-outline-secondary border border-left-0  form-rounded" type="button">
              <span class="fa fa-search">
              </span>
            </button>
          </span>
        </div>
      </form>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span class="fa fa-bell">
            </span>
          </a>
        </li>
        <li class="nav-item">
          <span class="navbar-text">
            Welcome, <% out.print(details.getName());%>
            
          </span>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class= "mx-2 my-auto w-full" method="GET">
            <a href="Logout.jsp" class="btn btn-secondary  form-rounded" >Logout
            
            </a>
          </form>
        </li>
      </ul>
    </nav>
    <div class="container-clearfix">
      <br>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 bg-light">
          <br>
          <nav class="navbar navbar-expand-md navbar-dark navbar-custom">
            <span class="navbar-text navbar-">
              <b>PROFILE
              </b>
            </span>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a href="" style="color:aliceblue">
                  <b>Edit
                  </b>
                </a>
              </li>
            </ul>
          </nav>
          <br>
          <center>
            <img src="images/profile.png" alt="Profile Picture" width="25%">
            <br>
            <br>
            <b><% out.print(details.getName());%>
            </b>
            <br>
            <br>
            ID: <% out.print(details.getId());%>
            <br> 
            <br>
            <br>
            Designation:
            <br>
            <% out.print(details.getDesgination());%>
            <br>
            <br>
            Office:
            <br>
             <% out.print(details.getOffice());%>
          </center>
        </div>
        <div class="col-md-6">
          <div class="container">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu1">VENDORS
                </a>
              </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
              <div id="home" class="container tab-pane active">
                <br>
                <br>
                <br>
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-8 bg-light   ">
                         <picture>
                        <center>
                          <br>
                          <br>
                          <br>
                          <label for="files">
                            <img src="images/add.png"/>
                        </label>
                          <input type="file" id="files" name="files[]" multiple hidden />
                          <br>
                          <br>
                          <br>
                          <b>Add Images
                          </b>
                          <br>
                          <br>
                        </center>
                      </picture>
                    </div>
                    
                    <div class="col-md-4">
                      <form class= "mx-2 my-auto w-full" action="addproduct" method="POST">
                        
                       <select name="category" placeholder="Category">
  <option value="Personal Care">Personal Care</option>
  <option value="Laptops">Laptops</option>
  <option value="Art Supplies">Art Supplies</option>
  <option value="Clothing">Clothing</option>
</select>
                        <input type="text" name="name" placeholder="Name" required>
                        <input type="text" name="description" placeholder="Description" required>
                        <input type="number"  name="price" placeholder="Price" required>
                         
                                  
                       <input id="prodId" name="userId" type="hidden" value="<%=details.getId()%>">
                       
                                   </div>
                  </div>   
                </div>
              </div>
              <div id="menu1" class="container tab-pane fade">
                <br>
              </div>
            </div>
            <!--tab ends here-->
          </div>
        </div>
        <div class="col-md-3">
          <button type="submit" class="btn btn-dark form-rounded" style="width:30%; position: absolute; bottom: 50px; right: 20px;" >Add
          </button>
          <br>
          
        </form>
        </div>
      </div>
      
      </body>
</html>