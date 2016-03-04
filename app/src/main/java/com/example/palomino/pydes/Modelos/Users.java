package com.example.palomino.pydes.Modelos;

/**
 * Created by Palomino on 29/02/2016.
 */
public class Users {


    public String Id;
    public String Name;
    public String Soy;
    public String Email;
    public String Pwd;
    public Boolean IsProvider ;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSoy() {
        return Soy;
    }

    public void setSoy(String soy) {
        Soy = soy;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public Boolean getIsProvider() {
        return IsProvider;
    }

    public void setIsProvider(Boolean isProvider) {
        IsProvider = isProvider;
    }




}
