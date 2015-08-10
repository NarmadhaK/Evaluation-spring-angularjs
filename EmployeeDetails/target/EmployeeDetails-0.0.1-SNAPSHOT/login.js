(function() {
	var app = angular.module('myApp',[]);

	app.controller('loginController',function($scope,$http)
			{
		var self=this;
		self.user={};
		self.log=function()
		{
			$http({
				url:"http://localhost:8080/EmployeeDetails/mapp/login",
		        method:"POST",
		        data:self.user,
		        headers : {
					"Content-Type" : "application/x-www-form-urlencoded; charset=utf-8"
				}
			})
		};
		});
	})();