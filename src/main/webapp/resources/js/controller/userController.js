"use strict";

angular.module('myApp').controller('formCtrl', function($scope,UserService) {
        
    $scope.addUser = "";
    $scope.updateUser = "";
 $scope.user ={};
        
    $scope.reset = function() {
        $scope.user = {name:"",address:"",email:""};
        $scope.user.id=undefined;
    };

    $scope.submit = function(){
       
       UserService.create($scope.user).then(function(response){
            console.log(response.data);
        
        $scope.addUser = response.data;

        $scope.getAllList();

       });
 
        
    };

    $scope.getAllList = function(){
            UserService.getAllList().then(function(response){

                console.log(response.data);
                $scope.userList = response.data;
            });
       };
       

       $scope.getAllList();

   $scope.delete = function(id){
           alert('delete');
            UserService.delete(id).then(function(response){

                console.log(response.data);
                $scope.userList = response.data;
            });
       };

        $scope.update = function(id){
           alert('update');
            UserService.update(id).then(function(response){

                console.log(response.data);
                var userData =response.data;
                console.log(userData);
                 $scope.user.id='';
                $scope.user.id=userData.id;
                 $scope.user.name=userData.name;
                  $scope.user.address=userData.address;
                   $scope.user.email=userData.email;
                $scope.user== {id:userData.id,name:userData.name,address:userData.address,email:userData.email};
            console.log($scope.user.id);
            console.log($scope.user);
            
            });
       };
       

    
});