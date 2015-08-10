(function(){
var app=angular.module('myApp', []);
app.controller('registrationController', function($scope,$http) 
		{
	    var self=this;
		self.Register = function()
        {
			$http({
			url:"http://localhost:8080/EmployeeDetails/mapp/register",
			method: "POST",
			data:self.user,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded; charset=utf-8"
			}
		});
      };
     });
})();





