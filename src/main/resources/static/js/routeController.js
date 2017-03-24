app.controller('routeController',
    ['routeService', '$scope',  function( routeService, $scope) {
 
        var self = this;
        self.route = {};
        self.routes=[];
        
        
        self.submit = submit;
        self.getAllRoutes = getAllRoutes;
        self.createRoute = createRoute;
        self.updateRoute = updateRoute;
        self.removeRoute = removeRoute;
        self.editRoute = editRoute;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.route.id === undefined || self.route.id === null) {
                console.log('Saving New Route', self.route);
                createRoute(self.route);
            } else {
                updateRoute(self.route, self.route.id);
                console.log('Route updated with id ', self.route.id);
            }
        }
 
        function createRoute(route) {
            console.log('About to create route');
            routeService.createRoute(route)
                .then(
                    function (response) {
                        console.log('Route created successfully');
                        self.successMessage = 'Route created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.route={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Route');
                        self.errorMessage = 'Error while creating Route: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
 
        function updateRoute(route, id){
            console.log('About to update route');
            routeService.updateRoute(route, id)
                .then(
                    function (response){
                        console.log('Route updated successfully');
                        self.successMessage='Route updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Route');
                        self.errorMessage='Error while updating Route '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
 
        function removeRoute(id){
            console.log('About to remove Route with id '+id);
            routeService.removeRoute(id)
                .then(
                    function(){
                        console.log('Route '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing route '+id +', Error :'+errResponse.data);
                    }
                );
        }
 
 
        function getAllRoutes(){
            return routeService.getAllRoutes();
        }
 
        function editRoute(id) {
            self.successMessage='';
            self.errorMessage='';
            routeService.getRoute(id).then(
                function (route) {
                    self.route = route;
                },
                function (errResponse) {
                    console.error('Error while removing route ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.route={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);