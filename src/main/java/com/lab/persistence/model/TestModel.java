package com.lab.persistence.model;


public class TestModel
{

  private String table;
  private String propiedad;
  private int id;
  private TestModel test;

    public TestModel getTest() {
        return test;
    }

    public void setTest(TestModel test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



  public String getTable()
  {
    return table;
  }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }


  public void setTable(String table)
  {
    this.table = table;
  }
}
