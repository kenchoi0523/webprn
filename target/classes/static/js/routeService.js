app.factory('routeService',
    ['$localStorage', '$http', '$q', '$location',
        function ($localStorage, $http, $q, $location) {
 
            var factory = {
                loadAllRoutes: loadAllRoutes,
                getAllRoutes: getAllRoutes,
                getRoute: getRoute,
                createRoute: createRoute,
                updateRoute: updateRoute,
                removeRoute: removeRoute
            };
 
            return factory;
 
            function loadAllRoutes() {
                console.log('Fetching all routes');
                var deferred = $q.defer();
                //var url = $location.absUrl() + "route";
                var url = "http://localhost:8080/route";
                $http.get(url)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all routes');
                            $localStorage.routes = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading routes');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllRoutes(){
                return $localStorage.routes;
            }
 
            function getRoute(id) {
                console.log('Fetching Route with id :'+id);
                var deferred = $q.defer();
                //var url = $location.absUrl() + "route";
                var url = "http://localhost:8080/route/";
                
                $http.get(url + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Route with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading route with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function createRoute(route) {
                console.log('Creating Route');
                var deferred = $q.defer();
                var url = $location.absUrl() + "route";
                                
                $http.post("http://localhost:8080/", route)
                    .then(
                        function (response) {
                            loadAllRoutes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Route : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function updateRoute(route, id) {
                console.log('Updating Route with id '+id);
                var deferred = $q.defer();
                var url = $location.absUrl() + "route";
                $http.put("http://localhost:8080/" + id, route)
                    .then(
                        function (response) {
                            loadAllRoutes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Route with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removeRoute(id) {
                console.log('Removing Route with id '+id);
                var deferred = $q.defer();
                var url = $location.absUrl() + "route";
                $http.delete("http://localhost:8080/" + id)
                    .then(
                        function (response) {
                            loadAllRoutes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Route with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
        }
    ]);