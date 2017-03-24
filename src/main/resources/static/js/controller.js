app.controller('homeController', ['$scope', function($scope) {
	$scope.message="Welcome to Routing Service UI";
}]
);

app.controller('enquiryController', ['$scope', function($scope) {
	$scope.message="This page is to enquire the daily data";
}]
);

//app.controller('configureController', ['$scope', function($scope) {
//	$scope.message="This page is to configure the route";
//}]
//);

app.controller('postdatahistorycontroller', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "postdatahistory";
         
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        var data = {
        	dataFrom: $scope.dataFrom,
            dataTo: $scope.dataTo
        };
         
         
        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
         
        $scope.dataFrom = "";
        $scope.dataTo = "";
    }
});
 
app.controller('getdatahistorycontroller', function($scope, $http, $location) {
    $scope.getfunction = function(){
    	//var url = $location.absUrl() + "getalldatahistory";
        
    	var url = "http://localhost:8080/getalldatahistory";
        
        var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
        
        $http.get(url, config).then(function (response) {
           	$scope.response = response.data;
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
});