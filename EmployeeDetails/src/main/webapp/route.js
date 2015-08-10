(function() {
	var app = angular.module("employeeDetails", [ 'ngRoute' ]);
	app.config(function($routeProvider) {
		$routeProvider.when('/Registration', {
			controller : 'registrationController',
			templateUrl : '/Registration.html'
				
		}).when('/Login', {
			controller : 'loginController',
			templateUrl : '/Login.html'
		}).otherwise({
            redirectTo: 'sample.html'
        });

	});
	})();