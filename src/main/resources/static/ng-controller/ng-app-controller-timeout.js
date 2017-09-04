//Para poder, pasado 2000ms que nos mande a la pantalla principal. Le pasamos $location
  
  app.controller('ng-app-controller-timeout',
['$scope','$timeout', '$location', function ($scope, $timeout, $location)
  {
    $scope.tiempo = true;

        $timeout(function ()
        {
          $scope.tiempo = false;
          //url a la que nos llevará
           $location.url("");
        }, 2000);

  }]);