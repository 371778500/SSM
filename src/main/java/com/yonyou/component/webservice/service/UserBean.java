package com.yonyou.component.webservice.service;
/**
 * webservice 返回的实体
 * @author luochp3
 *
 */
public class UserBean {  
    private int id;  
    private String name;  
      
    public UserBean(int id, String name) {  
        super();  
        this.id = id;  
        this.name = name;  
    }  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    @Override  
    public String toString() {  
        return "UserBean [id=" + id + ", name=" + name + "]";  
    }  
      
} 