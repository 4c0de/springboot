app.controller('ng-app-controller-buscador',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {
    var tiempo =
    {
      buscar:
      {
        id: null,
        ms: 750
      }
    };
    
   
    
    //funcion  para que salga el listado completo de los item al acceder al buscador.
    (function()
    {
        $http.post('listado',{})
        .then(function(respuesta)
            {
              var data =respuesta.data;  
              $scope.items=data;
              
          //para mostrar el numero de elementos encontrados en contador
          $scope.resultado=data.length;
            });
    })();
    
     
    $scope.busqueda = function (e)
    {
      var valor = e.target.value;
      
      $timeout.cancel(tiempo.buscar.id);
      tiempo.buscar.id = $timeout(function ()
      {
        //peticion post a mapping /buscador  
        $http.post('/buscador',
        {
          //propiedad que le vamos al back  
          nombre: valor
        })
        .then(function (respuesta)
        {
          var data = respuesta.data;
          
          //para mostrar el numero de elementos encontrados 
          $scope.resultado=data.length;
          console.log(JSON.stringify(data.length));
          
          //mostrar items
          $scope.items = data;
         
        });

      }, tiempo.buscar.ms);
    };
    
  }]);