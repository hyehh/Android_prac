package com.aoslec.networkjson;

import java.util.ArrayList;

public class Member {

    // Property
    private String name = null;
    private int age = 0;
    private ArrayList<String> hobbies = null;
    private int no = 0;
    private String id = null;
    private String pw = null;

    // Constructor
    public Member(String name, int age, ArrayList<String> hobbies, int no, String id, String pw) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.no = no;
        this.id = id;
        this.pw = pw;
    }

    // Method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
