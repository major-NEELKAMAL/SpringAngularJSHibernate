<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
	<body>
		
		<h1>Person List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>address</th><th>address</th><th>email</th><th>Delete</th></tr>  
   <c:forEach var="person" items="${listPersons}">   
   <tr>  
   <td>${person.id}</td>  
   <td>${person.name}</td>  
   <td>${person.address}</td>  
   <td>${person.email}</td>  
   
   <td><a href="edit/${person.id}">Edit</a></td>  
   <td><a href="delete/${person.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="addPerson">Add New Person</a>
	</body>
</html>