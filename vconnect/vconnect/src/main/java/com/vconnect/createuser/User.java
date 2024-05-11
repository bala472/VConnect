package com.vconnect.createuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class User {
    @Id
    private String email;
    private String name;
    private LocalDate dob;
    private String phone;
    public User(){
    }
    public User(String email, String name, LocalDate dob, String phone) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

