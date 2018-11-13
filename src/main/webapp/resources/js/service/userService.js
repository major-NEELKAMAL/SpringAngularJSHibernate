angular.module('myApp').service('UserService',function($http){


    this.create = function(user){
        alert(123);
       return $http.post('http://localhost:8080/SpringAngularJSHibernate/savePerson',user)
             .then(function(response){
               
                return response;
             },function(errResponse){
               
                return errResponse;
             });
             
    };

    this.getAllList = function(){
       
       return $http.get('http://localhost:8080/SpringAngularJSHibernate/listPerson')
             .then(function(response){
               console.log(response);
                return response;
             },function(errResponse){
               
                return errResponse;
             });
             
    };

    this.delete = function(id){
       
       return $http.get('http://localhost:8080/SpringAngularJSHibernate/delete/'+id)
             .then(function(response){
               console.log(response);
                return response;
             },function(errResponse){
               
                return errResponse;
             });
    };

    this.update = function(id){
       
       return $http.get('http://localhost:8080/SpringAngularJSHibernate/edit/'+id)
             .then(function(response){
               console.log(response);
                return response;
             },function(errResponse){
               
                return errResponse;
             });

    };

});