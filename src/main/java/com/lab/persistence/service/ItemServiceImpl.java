
package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemMapper;
import com.lab.persistence.model.ItemModel;
import com.lab.persistence.model.PesoItems;
import java.util.List;
import java.util.regex.Pattern;
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
    public List<ItemModel> listaPeso(PesoItems objeto)throws Exception{
      List<ItemModel> lista= iMapper.listaPeso(objeto);

      return lista;
}

    @Override
    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception {
        List<ItemModel> lista= iMapper.listaCompletaItem(objeto);
        
       //Metodo que llamamos para reemplazar las busquedas por el subrayado.
        //vamos a devolver ya la lista con los campos ya reemplazados.
         List<ItemModel> listaReplace = this.listaReplace(objeto, lista);

        return listaReplace;
    }
    
    //metodo privado para el reemplazo.
     private List<ItemModel> listaReplace(ItemModel objeto, List<ItemModel> lista)
  {

    for (ItemModel item : lista)
    {
      item.setNombre(this.pattern(objeto.getNombre()).matcher(item.getNombre()).replaceAll(this.patternReplace(objeto.getNombre())));
      item.setDescripcion(this.pattern(objeto.getDescripcion()).matcher(item.getDescripcion()).replaceAll(this.patternReplace(objeto.getDescripcion())));
    }

    return lista;
  }

  private Pattern pattern(String str)
  {
    return Pattern.compile("(?i)" + str);
  }

  private String patternReplace(String str)
  {
    return "<strong class=\"found\">" + str + "</strong>";
  }




}


