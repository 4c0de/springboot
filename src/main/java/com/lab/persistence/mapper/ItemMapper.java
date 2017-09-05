
package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemModel;
import com.lab.persistence.model.PesoItems;
import java.util.List;


  /**
   * Metodo que devuelve todos los elementos almacenados en la bbdd basado en la busqueda.
   *
   * @param objeto Objeto tipo ItemModel.
   *
   * @return Lista de objetos tipo ItemModel.
   */

public interface ItemMapper {
    
    public List<ItemModel> ItemMapper(ItemModel objeto) throws Exception;
    
    
   /**
   * Devuelve todos los elementos almacenados en la bbdd.
   *
   * @param objeto Objeto tipo ItemModel.
   *
   * @return Lista de objetos tipo ItemModel.
   */

    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception;
    
    public List<ItemModel> listaPeso(PesoItems objeto)throws Exception;
    
    

}




