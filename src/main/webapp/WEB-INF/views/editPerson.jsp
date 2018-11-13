<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/angularjsMVCspring/savePerson" modalAttribute="person">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>address :</td>    
          <td><form:input path="address" /></td>  
         </tr>
         
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
          
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    