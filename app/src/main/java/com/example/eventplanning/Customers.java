package com.example.eventplanning;


public class Customers extends Users {


    private int id=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customers(int id,String name, String password, String email) {
        super(name,password,email);
        this.id=id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
             '}';
}

}
