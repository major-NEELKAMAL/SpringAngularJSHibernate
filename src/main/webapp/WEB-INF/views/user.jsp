<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>

<div ng-app="myApp" ng-controller="formCtrl">
  <form novalidate>
   
    <input type="hidden" ng-model="user.id" ng-show="user.id !='undefined' ") ><br>
    Name:<br>
    <input type="text" ng-model="user.name"><br>
    Address:<br>
    <input type="text" ng-model="user.address"><br>
    Email:<br>
    <input type="text" ng-model="user.email">
    <br><br>
    <button ng-click="submit()">SUBMIT</button>
    <button ng-click="reset()">RESET</button>
    
  </form>
  
 <div ng-if="addUser != '' " ><p>{{addUser}}</p></div>
 <div ng-if="updateUser != '' " ><p>{{updateUser}}</p></div>
 
 
 <div>
 	<table  border="1">
 		<thead>
    		<tr>
      			<th>Name</th>
      			<th>Address</th>
      			<th>Email</th>
      			<th>Edit</th>
      			<th>Delete</th>
    		</tr>
  		</thead>
  		<tbody>
    		 <tr ng-repeat="x in userList">
    			<td>{{ x.name }}</td>
    			<td>{{ x.address }}</td>
    			<td>{{ x.email }}</td>
    			<td><button  ng-click="update(x.id)">Update</button></td>
    			<td><button  ng-click="delete(x.id)">Delete</button></td>
  			</tr>
  		</tbody>
 	</table>
 </div>
 
</div>

<script src="<c:url value='/resources/js/app.js' />"></script>
<script src="<c:url value='/resources/js/service/userService.js' />"></script>
<script src="<c:url value='/resources/js/controller/userController.js' />"></script>
</body>
</html>