var app = angular.module('app', ['ngRoute']);


app.config(['$routeProvider', '$locationProvider',
  function ($routeProvider, $locationProvider)
  {
    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })
    .when('/',
    {
      templateUrl: GBL_COFG.urlTemplate('inicial.html')
    })
    .when('/pagina1',
    {
      templateUrl: GBL_COFG.urlTemplate('pagina1.html'),
      controller: 'ng-app-controller-template1'
    })
    .when('/about',
    {
      templateUrl: GBL_COFG.urlTemplate('about.html')
    })
    
     .when('/buscador',
    {
      templateUrl: GBL_COFG.urlTemplate('buscador.html')
    })
    .when('/pagina2',
    {
      templateUrl: GBL_COFG.urlTemplate('pagina2.html')
   
    });
  }]);


app.directive('apploading',
['$http', function ($http)
  {
    var loading =
    {
      restrict: 'A',
      link: function (scope, elm, attrs)
      {
        scope.isLoading = function ()
        {
          return $http.pendingRequests.length > 0;
        };

        scope.$watch(scope.isLoading, function (v)
        {
          if (v)
          {
            elm[0].classList.add('appLoading');
          }
          else
          {
            elm[0].classList.remove('appLoading');
          }
        });
      }
    };

    return loading;
  }]);



