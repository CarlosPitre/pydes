package com.example.palomino.pydes.extras;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por Hermosa Programación.
 */
public class GsonAnimalParser {

    // Convertir de JSON a  lista de objetos
    public List<Animal> leerFlujoJson(InputStream in) throws IOException {

        // Nueva instancia de la clase Gson
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(in,"UTF-8"));
        List<Animal> animales = new ArrayList<>();

        // Iniciar el array
        reader.beginArray();

        while (reader.hasNext()) {
            // Lectura de objetos
            Animal animal = gson.fromJson(reader, Animal.class);
            animales.add(animal);
        }

        reader.endArray();
        reader.close();
        return animales;
    }
}
