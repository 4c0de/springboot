
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
        return iMapper.listaCompletaItem(objeto);
    }
    
}
