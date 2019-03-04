<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String select[]=request.getParameterValues("checkbox11");
out.println("hjkdhfg");
if(select != null && select.length !=0)
{
for(int i=0;i<select.length;i++)
{
out.println(select[i]);
out.println("fdgjs");
}
}%>

</body>
</html>