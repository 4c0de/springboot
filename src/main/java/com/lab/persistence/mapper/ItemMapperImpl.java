
package com.lab.persistence.mapper;
import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemModel;
import com.lab.persistence.model.PesoItems;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemMapperImpl implements ItemMapper
{

  @Autowired
  BBDD basedatos;


  @Override
  public List<ItemModel> ItemMapper(ItemModel objeto) throws Exception
  {
    List<ItemModel> lista = new ArrayList<>();

    /**
     * Conectando a la bbdd
     */
    basedatos.conecta();

    /**sentencia que seleccionara nombre, categoria y descripcion que cumpla los criterios
     * de búsqueda
    */
    String sql = "SELECT * FROM items where (nombre LIKE '%" + objeto.getNombre() + "%')" +
             "OR (categoria LIKE '%" + objeto.getCategoria() + "%')"+
             "OR (descripcion LIKE '%" + objeto.getDescripcion() + "%')";

    ResultSet resultado = basedatos.consulta(sql);
    while (resultado.next())
    {
      ItemModel item = new ItemModel();

      item.setId(resultado.getInt("id"));
      item.setNombre(resultado.getString("nombre"));
      item.setDescripcion(resultado.getString("descripcion"));
      item.setUrl(resultado.getString("url"));    
      item.setCategoria(resultado.getString("categoria"));
      lista.add(item);
       
    }
    /**
     * Desconectando de la bbdd
     */
    basedatos.desconecta();

    return lista;
  }

    @Override
    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception {
       
    List<ItemModel> lista = new ArrayList<>();

    /**
     * Conectando a la bbdd
     */
    basedatos.conecta();

     //Sentencia SQL que devuelve todos los campos de la tabla items.
    String sql = "SELECT * FROM items";

    ResultSet resultado = basedatos.consulta(sql);
    while (resultado.next())
    {
      ItemModel item = new ItemModel();

      item.setId(resultado.getInt("id"));
      item.setNombre(resultado.getString("nombre"));
      item.setDescripcion(resultado.getString("descripcion"));
      item.setUrl(resultado.getString("url"));
        item.setCategoria(resultado.getString("categoria"));
      lista.add(item);
       
    }
    /**
     * Desconectando con la bbdd
     */
    basedatos.desconecta();

    return lista;
  }
    
    @Override
    public List<ItemModel> listaPeso(PesoItems objeto)throws Exception{
        
         List<ItemModel> lista = new ArrayList<>();

    /**
     * Conectando a la bbdd
     */
    basedatos.conecta();
    
     /**
     * Sentencia que devuelve todos los campos de la tabla items en donde el id sea igual
     *  al iditem de tabla pesoitem y peso sea igual a criterio de busqueda.
     */
   
    String sql = "SELECT * FROM items where id IN"
            + "(SELECT iditem from pesoitem where peso ="+objeto.getPeso()+")";
    

    ResultSet resultado = basedatos.consulta(sql);
    while (resultado.next())
    {
      ItemModel item = new ItemModel();
      item.setId(resultado.getInt("id"));
      item.setNombre(resultado.getString("nombre"));
      item.setDescripcion(resultado.getString("descripcion"));
      item.setUrl(resultado.getString("url"));
        item.setCategoria(resultado.getString("categoria"));
      lista.add(item);
       
    }
    /**
     * Desconectando con la bbdd
     */
    basedatos.desconecta();

    return lista;
        
        
        
        
        
        
    }
    

}