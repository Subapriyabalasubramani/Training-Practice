<%@ page import="java.util.*" %>
<%@ page import="com.example.model.Student" %>


<!DOCTYPE>
<html lang="en">
<head>
<title>Students List</title>
</head>
<body style="font-family:Arial;">
<h2>Registered Students</h2>
<table border="1">
<tr>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Address</th>
<th>Action</th>
</tr>

<%
  List<?> students = (List<?>) request.getAttribute("studentsList");
  if(students != null){
    for(Object obj : students){
       Student s = (Student)obj;
%>
<tr>
   <td><%= s.getName() %></td>
   <td><%= s.getEmail() %></td>
   <td><%= s.getPhone() %></td>
   <td><%= s.getAddress() %></td>
   <td><a href="/students/delete?email=<%= s.getEmail() %>">Delete</a></td>
</tr>
<%
}
}
%>

</table>

<br/>
<a href="/students/new">Add New Student</a>

</body>
</html>


