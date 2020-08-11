package com.netvuvu.file;

import java.util.ArrayList;
import java.util.List;

public class Linea{
    String texto;

    public Linea (String otexto){
        this.texto=otexto;
    }

    public Boolean checkLength(){
        if (texto.length()>280) {return true;}
        return false;
    }

    public ArrayList<Integer> returnPositions(char caracter) {

        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                posiciones.add(i);

            }
        }
        return posiciones;
    }

    public Integer closestPeriod(List<Integer> posiciones){
        Integer max=0;
        for (Integer i : posiciones){
            if(i<280 && i>max){max=i;}
        }
        return max;
    }

    public String substring(Integer longitud,String texto){
        if(texto.length()<longitud){

            return texto;

        } else {
            Linea linea = new Linea(texto);
            ArrayList<Integer> posicionesPunto = linea.returnPositions('.');
            Integer max = linea.closestPeriod(posicionesPunto);
            if(max==0){
                ArrayList<Integer> posicionesEspacio = linea.returnPositions(' ');
                max = linea.closestPeriod(posicionesEspacio);
            }
            System.out.println("max es " + max);
            System.out.println("length es "+texto.length());

            String med_text = texto.substring(0,max-1);
            String loQueQueda = texto.substring(max, texto.length()-1);
            if(loQueQueda.length() > longitud) {
                //Linea linea1 = new Linea(loQueQueda);
                //llamada recursiva
                this.substring(longitud, loQueQueda);

            }

                return med_text;
        }
    }
}
