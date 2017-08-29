app.controller('ng-app-controller-template1', ['$scope', '$http', function ($scope,
  $http)
  {
    console.log('1');
    $scope.mensaje = 'Texto cargado desde el controlador Pagina1Controller';

    $http.post('/test',
    {
      propiedad: 'hello',
      table: 'Antonio',
      
      test:
      {
      propiedad: 'aaa',
      table: 'manolo',
      id:1
      }
    })
    .then(function (response)
    {
      console.log(response.data);
      $scope.mensaje="ajax completado \n";
      
      var data=response.data;
      
                    for (var i = 0; i < data.length; i++) {
                            
                        console.log(data[i].table);
                         $scope.mensaje+=data[i].table+"\n";
                    }              
     
                        
                    
    });

  }]);