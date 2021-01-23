package sample;

import javafx.scene.Scene;

public class Busqueda {

    public int secuencial(String[][] arreglo,String dato1,String dato2){
        int indice = -1;
        for (int x=0;x<arreglo.length;x++){
            if (arreglo[x][0].equals(dato1)&&arreglo[x][1].equals(dato2)){
                indice=x;
                return indice;
            }
        }
        return indice;
    }

    public int binaria(Libro[] arreglo,int superior,double numerobuscado){
        int inferior=0;
        int centro=0;

        if (numerobuscado>arreglo[arreglo.length-1].precio){
            return -1;
        }

        while (inferior<=superior){

            centro= (superior+inferior)/2;

            if (arreglo[centro].precio==numerobuscado){
                return centro;
            }else if (numerobuscado<arreglo[centro].precio){
                superior=centro-1;
            }else {
                inferior=centro+1;
            }
        }

        return -1;
    }
}
