
package com.lab.persistence.mapper;
import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemMapperImpl implements ItemMapper
{

  @Autowired
  BBDD db;


  @Override
  public List<ItemModel> ItemMapper(ItemModel obj) throws Exception
  {
    List<ItemModel> lista = new ArrayList<>();

    /**
     * CONECTANDO A LA BBDD.
     */
    db.conecta();

    String sql = "SELECT * FROM items where (nombre LIKE '%" + obj.getNombre() + "%')";

    ResultSet rs = db.consulta(sql);
    while (rs.next())
    {
      ItemModel item = new ItemModel();

      item.setId(rs.getInt("id"));
      item.setNombre(rs.getString("nombre"));
      item.setDescripcion(rs.getString("descripcion"));
      item.setUrl(rs.getString("url"));

      lista.add(item);
    }
    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta();

    return lista;
  }

}