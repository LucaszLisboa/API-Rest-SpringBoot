package com.lisboa.userdepart.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    //creating relationships between entities
    @ManyToOne  //relationships
    @JoinColumn (name = "department_id")  //name foreign key
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
