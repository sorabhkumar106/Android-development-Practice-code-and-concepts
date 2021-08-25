package com.example.recycleviewexample4;

public class Contacts {
    public int sno;
    public int phone;
    public String name;
    public  Contacts(int sno,int phone,String name){
        this.sno=sno;
        this.phone=phone;
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public  int getSno(){
        return  sno;
    }
    public int getPhone(){
        return phone;
    }
}
