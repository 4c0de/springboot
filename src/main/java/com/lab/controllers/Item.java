/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.controllers;

import com.lab.persistence.model.ItemModel;
import com.lab.persistence.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lenovo
 */

@Controller
public class Item {
    
    
 @Autowired
 ItemService iService;
 
   @ResponseBody
  @RequestMapping(value = "/buscador",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemModel> listar(@RequestBody ItemModel objeto) throws Exception
  {
   
       
       
    List<ItemModel> lista = iService.listaItem(objeto);

    return lista;
  }

}
 
    
    

