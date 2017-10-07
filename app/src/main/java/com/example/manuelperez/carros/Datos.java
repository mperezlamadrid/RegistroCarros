package com.example.manuelperez.carros;

import java.util.ArrayList;

/**
 * Created by manuelperez on 10/7/17.
 */

public class Datos {
    private static ArrayList<Carro> carros = new ArrayList();

    public static void guardarCarro(Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> obtenerCarros(){
        return carros;
    }
}
