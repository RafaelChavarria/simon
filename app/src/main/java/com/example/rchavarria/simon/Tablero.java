package com.example.rchavarria.simon;

import android.content.ClipData;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rchavarria on 29/11/2017.
 */



public class Tablero {

    private ArrayList<String> pads = new ArrayList<String>();
    private ArrayList<String> sequence = new ArrayList<String>();
    public boolean turno = false;
    private Random random;
    public Integer marcador = 0;

    public Tablero() {

        nuevo();
    }

    public void nuevo() {
        this.turno = false;
        this.sequence.clear();
        this.marcador = 0;
        pads.add("G");
        pads.add("R");
        pads.add("Y");
        pads.add("B");
    }

    public ArrayList<String> jugar (){
        this.turno = false;
        random = new Random();
        int randomIndex = random.nextInt(pads.size());
        String nextPad = pads.get(randomIndex);
        sequence.add(nextPad);
        print();
        return sequence;
    }

    public void turnoJugador(){
        this.turno = true;
    }

    public Boolean inputJugador(String posicion, String input){
        Log.d("InputS: ", posicion);
        Log.d("InputU: ", input);
        if (posicion!=input){
            Log.d("InputRes: ", "Perdiste!");
            return false;
        }else{
            Log.d("InputRes: ", "Acertaste!");
            return true;
        }

    }

    public int score(){
        marcador++;
        return marcador;
    }



    public void print(){
        String temp ="";
        for(int i = 0 ; i < sequence.size(); i++){
            temp += sequence.get(i);
        }
        Log.d("Secuencia: ",temp);
    }



}
