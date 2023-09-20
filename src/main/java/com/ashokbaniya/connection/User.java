package com.ashokbaniya.connection;

public class User {
    public String f_name;
    public String l_name;
    public String user_type;
    public String email;
    public String contact_no;
    public String address;
    public String password;
    public User() {
        // Default constructor required for DataSnapshot.getValue(User.class)
    }

    public User(String f_name,String l_name, String user_type, String email, String contact_no, String address, String password) {
        this.f_name = f_name;
        this.l_name =l_name ;
        this.user_type=user_type;
        this.email = email;
        this.contact_no =contact_no;
        this.address =address;
        this.password= password;
    }
}