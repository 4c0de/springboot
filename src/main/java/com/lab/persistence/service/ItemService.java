
package com.lab.persistence.service;

import com.lab.persistence.model.ItemModel;

import java.util.List;

/**
 *
 * @author Lenovo
 */


 
public interface ItemService {
    
    public List<ItemModel> listaItem(ItemModel objeto) throws Exception;

    public List<ItemModel> listaCompletaItem(ItemModel objeto)throws Exception;
    
    
    
}
