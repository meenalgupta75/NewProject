<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product</title>
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
   
    <link rel="stylesheet" href="styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        input[type="file"] {
    
         display:block;
        }
        .imageThumb {
         max-height: 75px;
         border: 2px solid;
         margin: 10px 10px 0 0;
         padding: 1px;
         }
        </style>
        <script type="text/javascript">
       $(document).ready(function() {
  if (window.File && window.FileList && window.FileReader) {
    $("#files").on("change", function(e) {
      var files = e.target.files,
        filesLength = files.length;
      for (var i = 0; i < filesLength; i++) {
        var f = files[i]
        var fileReader = new FileReader();
        fileReader.onload = (function(e) {
          var file = e.target;
          $("<span class=\"pip\">" +
            "<img class=\"imageThumb\" width=\"25%\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
            "<br/><span class=\"remove\">Remove image</span>" +
            "</span>").insertAfter("#files");
          $(".remove").click(function(){
            $(this).parent(".pip").remove();
          });
        
          
        });
        fileReader.readAsDataURL(f);
      }
    });
  } else {
    alert("Your browser doesn't support to File API")
  }
});
        </script> 
</head>

<body>
<nav class="navbar navbar-expand-md navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="\images\smlogo.png" alt="logo">
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
            Welcome, <%String name=request.getParameter("username"); %>
<%out.print(name); %>
            
          </span>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class= "mx-2 my-auto w-full" method="GET">
            <a href="logout.jsp" class="btn btn-secondary  form-rounded" >Logout
            
            </a>
          </form>
        </li>
      </ul>
    </nav>





<% ArrayList<Product> pl=(ArrayList)request.getAttribute("product"); %>


<table style="width:100%" border="1">

<tr>
<td bgcolor="00bfff"><b>ID</b></td>
<td bgcolor="00bfff"><b>name</b></td>
<td bgcolor="00bfff"><b>category</b></td>
<td bgcolor="00bfff"><b>discription</b></td>
<td bgcolor="00bfff"><b>price</b></td>
<td bgcolor="red"><a href="AddProduct.jsp" class="btn btn-info" role="button">Add Product</a></td>




</tr>
<%for(Product p:pl){%>
<tr>
<td  ><%out.print(p.getId()); %></td>
<td><%out.print(p.getName()); %></td>
<td><%out.print(p.getCategory()); %></td>
<td><%out.print(p.getDiscription()); %></td>
<td><%out.print(p.getPrice()); %></td>

<td><a href="delete?id=<%=p.getId() %>" class="btn btn-info" role="button""/>delete</a></td>
<td><a href="view?id=<%=p.getId() %>" class="btn btn-info" role="button""/>view</a></td>



</tr>

<%};%>

</table>



</body>
</html>