package com.example.manuelperez.carros;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by manuelperez on 10/7/17.
 */

public class Metodos {
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();

        fotoSeleccionada = r.nextInt(fotos.size());

        return fotos.get(fotoSeleccionada);
    }
}
