package com.lisboa.userdepart.entities;

public class User {

    private Long id;
    private String name;
    private String email;

    //creating relationships between entities
    private Department department;

    public User(){
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public Department getDepartment(){
        return department;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDepartment(Department department){
        this.department = department;
    }


}
