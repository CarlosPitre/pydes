package com.example.palomino.pydes.Modelos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.palomino.pydes.extras.GsonAnimalParser;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Created by Palomino on 29/02/2016.
 */
public class DatosUser {

    public static final String PREFS_NAME = "MY_PREFERENCIA";
    public static final String PREFS_KEY = "AOP_PREFS_String";


    //string 	PackageName;
    private   SharedPreferences Datos;
    private   SharedPreferences.Editor edit;


    public DatosUser (Context context)
    {
        Datos = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        edit = Datos.edit();
        //edit.commit();
    }


    public void SetUser (Users valor)
    {



    }

    public Users GetUser ()
    {
        Users users = new Users();
        return users  ;

    }



    public void SetProfil (Profils valor)
    {


    }
    public Profils GetProfil ()
    {
       Profils users = new Profils();
        return users  ;
    }

}
