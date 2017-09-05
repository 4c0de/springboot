
package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemMapper;
import com.lab.persistence.model.ItemModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired 
    ItemMapper iMapper;
    
    
    @Override
    public List<ItemModel> listaItem(ItemModel objeto) throws Exception {
     
        return iMapper.ItemMapper(objeto);
    }

    @Override
    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception {
        List<ItemModel> lista= iMapper.listaCompletaItem(objeto);
        
       //Metodo que llamamos para reemplazar las busquedas por el subrayado.
        //this.sustituir(lista,objeto);
        //vamos a devolver ya la lista con los campos ya reemplazados.
        return lista;
    }

//    private void sustituir(List<ItemModel> lista, ItemModel objeto) {
//        
//        for (int i = 0; i < lista.size(); i++) {
//          
//            
//        }
//      
//    }
    

}


