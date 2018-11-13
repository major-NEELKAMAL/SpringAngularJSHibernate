<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    



		
	   
  
        <h1>Add New Employee</h1>  
       <form:form method="post" action="/angularjsMVCspring/savePerson" modelAttribute="person">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input name="name" type="text" path="name" /></td>  
         </tr>    
         <tr>    
          <td>Address :</td>    
          <td><form:input name="address" type="text" path="address"/></td>  
         </tr> 
         
          <tr>    
          <td>Email :</td>    
          <td><form:input name="email" type="text" path="email"/></td>  
         </tr>    
          
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Add" /></td>    
         </tr>    
        </table>    
       </form:form>    
<a href="listPerson">Person List</a>