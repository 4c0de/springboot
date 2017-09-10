
package com.lab.persistence.service;

import com.lab.persistence.model.ItemModel;
import com.lab.persistence.model.PesoItems;

import java.util.List;

/**
 *
 * @author Lenovo
 */


 
public interface ItemService {
    
   /**
    * Obtiene una lista de items según unos criterios de busqueda.
    * @param objeto  objeto de tipo ItemModel
    * @return Lista de objetos de tipo itemModel
    * @throws Exception 
    */
    
    public List<ItemModel> listaItem(ItemModel objeto) throws Exception;
    
    /**
     * Obtiene todos los items almacenados.
     * @param objeto objeto de tipo ItemModel
     * @return Lista de objetos de tipo itemModel
     * @throws Exception 
     */

    public List<ItemModel> listaCompletaItem(ItemModel objeto)throws Exception;
    
    
       /**
    * Obtiene una lista de items según unos criterios de busqueda por peso.
    * @param objeto  objeto de tipo  PesoItems
    * @return Lista de objetos de tipo ItemModel.
    * @throws Exception 
    */
    
     public List<ItemModel> listaPeso(PesoItems objeto)throws Exception;
     
     public void borrar(ItemModel objeto)throws Exception;
     
     public void insertar(ItemModel objeto) throws Exception; 
      
      
    
}
