package com.example.psipsi.retorofit.user;

public class User {
    int id;
    String name;
    String role;
    String nik;

    public User(int id, String name, String role,String nik) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.nik = nik;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
}
