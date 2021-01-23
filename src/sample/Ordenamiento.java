package sample;

public class Ordenamiento {

    public static Libro[] burbuja(Libro[] arreglo) {
        double auxiliar;
        String auxiliar1;
        Libro[] arregloOrdenado;
        for(int i = 1; i < arreglo.length; i++) {
            for(int j = 0;j < arreglo.length-i;j++) {
                if(arreglo[j].precio > arreglo[j+1].precio) {
                    auxiliar = arreglo[j].precio; auxiliar1=arreglo[j].titulo;
                    arreglo[j].precio = arreglo[j+1].precio; arreglo[j].titulo=arreglo[j+1].titulo;
                    arreglo[j+1].precio = auxiliar; arreglo[j+1].titulo=auxiliar1;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    public static Double[] shell(Double[] arreglo){

        int salto;
        int i;
        int j;
        int k;
        Double auxiliar;
        salto=arreglo.length/2;

        while (salto>0){
            for (i=salto;i<arreglo.length;i++){
                j=i-salto;
                while (j>=0){
                    k=j+salto;
                    if (arreglo[j]<=arreglo[k]){
                        j=-1;
                    }else {
                        auxiliar=arreglo[j];
                        arreglo[j]=arreglo[k];
                        arreglo[k]=auxiliar;
                        j-=salto;
                    }
                }
            }
            salto=salto/2;
        }
        return arreglo;
    }


}
