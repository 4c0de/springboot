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
      var colorContador =document.querySelector('#resultado');
      
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
          //mostramos longitud por consola
          console.log(JSON.stringify(data.length));
          
          //mostrar items
          $scope.items = data;
          
          //Si no encontrado ponemos el contador numerico a rojo
          if (data.length===0){
              colorContador.style.color="#FF0000";
          }else{
              //ponemos a blanco si longitud es mayor que cero
              colorContador.style.color="#FFFFFF";
              
          }
         
        });

      }, tiempo.buscar.ms);
    };
    
  }]);