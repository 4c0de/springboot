//Viene del index  ng-app="app"> le pasamos parametro ngRoute para las redirecciones./
//creamos el modulo y lo realacionamos con el html
var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider,
  $locationProvider)
  {
//    $locationProvider.html5Mode(true);


    $routeProvider.otherwise(
    { 
      //cuando no encuentra la ruta
      redirectTo: '/'
    })
    //cuando encuentra la ruta 
    .when('/pagina1',
    { 
      //GBL_COF esta desarrollado por alfonso. /
      //Se carga el template con el controlador
      templateUrl: GBL_COFG.urlTemplate('pagina1.html'),
      controller: 'ng-app-controller-template1'
    })

    .when('/pagina2',
    {
      templateUrl: GBL_COFG.urlTemplate('pagina2.html'),
      controller: 'ng-app-controller-template2'
    });
  }]);

//recibe una cadena y un array que tiene en el indice 0 un string y en el indice 1 una funcion.
app.directive('apploading', ['$http', function ($http)
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


