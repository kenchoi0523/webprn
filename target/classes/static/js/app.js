/**
 * 
 */

var app = angular.module('app', ['ngRoute', 'ngStorage']);

//app.config(['$locationProvider', function($locationProvider) {
//	  $locationProvider.hashPrefix('');
//}]);



app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){
    $routeProvider
	    .when('/', {
			templateUrl: 'home.html',
			controller: 'homeController'
		})
    	.when('/home', {
    		templateUrl: 'home.html',
    		controller: 'homeController'
    	})
        .when('/enquiry',{
            templateUrl: 'enquiry.html',
            controller: 'enquiryController'
            
        })
        .when('/configure',{
            templateUrl: 'configure.html',
            controller: 'routeController',
            controllerAs: 'ctrl',
            resolve: {
                routes: function ($q, routeService) {
                    console.log('Load all users');
                    var deferred = $q.defer();
                    routeService.loadAllRoutes().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        })
        .otherwise(
            { redirectTo: '/'}
        );
    
//    $locationProvider.html5Mode({
//    	  enabled: true,
//    	  requireBase: false
//    	});

}]);


