package com.example.admin.passwordinsertion;

/**
 * Created by Admin on 22-04-2017.
 */

public class Student {

    int id;
    String name,phone,email,city,password;

    public Student() {
    }

    public Student(int id, String name, String phone, String email, String city, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
