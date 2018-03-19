package com.daily.model; 

/**
 * Created By FeastCoding.
 */
public class Url { 
    private Integer id;
    private String name;
    private String url;
    private Integer typeid;

    public Integer getId(){
      return id;
    }
    public void setId(Integer id){
      this.id = id;
    }
    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }
    public String getUrl(){
      return url;
    }
    public void setUrl(String url){
      this.url = url;
    }
    public Integer getTypeid(){
      return typeid;
    }
    public void setTypeid(Integer typeid){
      this.typeid = typeid;
    }

}
