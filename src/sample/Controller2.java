package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Controller2 {

    String libro;

    Image ana = new Image("file:src/sample/Img/best/ana.png");
    Image anilllos = new Image("file:src/sample/Img/best/anillos.png");
    Image codigo = new Image("file:src/sample/Img/best/codigo.png");
    Image orgullo = new Image("file:src/sample/Img/best/orgullo.png");
    Image principe = new Image("file:src/sample/Img/best/principe.png");
    Image comedia = new Image("file:src/sample/Img/clasica/comedia.png");
    Image hamlet = new Image("file:src/sample/Img/clasica/hamlet.png");
    Image odisea = new Image("file:src/sample/Img/clasica/odisea.png");
    Image quijote = new Image("file:src/sample/Img/clasica/quijote.png");
    Image viaje = new Image("file:src/sample/Img/clasica/viaje.png");
    Image estrella = new Image("file:src/sample/Img/juvenil/estrella.png");
    Image hp = new Image("file:src/sample/Img/juvenil/hp.png");
    Image juegos = new Image("file:src/sample/Img/juvenil/juegos.png");
    Image maze = new Image("file:src/sample/Img/juvenil/maze.png");
    Image ola = new Image("file:src/sample/Img/juvenil/ola.png");

    @FXML ImageView viewlibro;
    @FXML TextField txtprecio,txtcantidad,txttotal;
    @FXML TextField txtorden,numerobuscar;
    @FXML ListView lista,lista2,lista3;
    @FXML Button btagregar,btretirar;
    @FXML Button btpagar,btmandar;

    @FXML ComboBox combobest,comboclasica,combojuvenil;
    LinkedList<String> listabest = new LinkedList<>();
    LinkedList<String> listaclasica = new LinkedList<>();
    LinkedList<String> listajuvenil = new LinkedList<>();

    Stack<Libro> pilalibro = new Stack<>();
    Queue<Double> colaorden = new LinkedList<>();

    Libro[] arregloLibro = new Libro[5];
    Double[] arregloOrden = new Double[5];

    int contador=0;
    int contador2=0;

    @FXML protected void initialize(){

        listabest.add("Orgullo y prejuicio");
        listabest.add("El señor de los anillos");
        listabest.add("Diario de Ana Frank");
        listabest.add("El código Da Vinci");
        listabest.add("El principito");

        listaclasica.add("Viaje al centro de la Tierra");
        listaclasica.add("La Divina comedia");
        listaclasica.add("Don Quijote de la Mancha");
        listaclasica.add("La Odisea");
        listaclasica.add("Hamlet");

        listajuvenil.add("Harry Potter y las Reliquias de la Muerte");
        listajuvenil.add("Maze Runner: Correr o morir");
        listajuvenil.add("La quinta ola");
        listajuvenil.add("Los juegos del hambre");
        listajuvenil.add("Bajo la misma estrella");

        for (int x=0;x<listabest.size();x++) combobest.getItems().add(listabest.get(x));
        for (int x=0;x<listaclasica.size();x++) comboclasica.getItems().add(listaclasica.get(x));
        for (int x=0;x<listajuvenil.size();x++) combojuvenil.getItems().add(listajuvenil.get(x));

        btmandar.setDisable(true);
        btpagar.setDisable(true);
    }

    public void imgbest(ActionEvent event){
        int x=combobest.getSelectionModel().getSelectedIndex();
        switch (x){
            case 0: viewlibro.setImage(orgullo); libro="Orgullo y prejuicio"; txtprecio.setText("300"); break;
            case 1: viewlibro.setImage(anilllos); libro="El señor de los anillos"; txtprecio.setText("240"); break;
            case 2: viewlibro.setImage(ana); libro="Diario de Ana Frank"; txtprecio.setText("220"); break;
            case 3: viewlibro.setImage(codigo); libro="El código Da Vinci"; txtprecio.setText("480"); break;
            case 4: viewlibro.setImage(principe); libro="El Principito"; txtprecio.setText("200"); break;
        }
    }

    public void imgclas(ActionEvent event){
        int x=comboclasica.getSelectionModel().getSelectedIndex();
        switch (x){
            case 0: viewlibro.setImage(viaje); libro="Viaje al centro de la Tierra"; txtprecio.setText("220"); break;
            case 1: viewlibro.setImage(comedia); libro="La Divina comedia"; txtprecio.setText("280"); break;
            case 2: viewlibro.setImage(quijote); libro="Don Quijote de la Mancha"; txtprecio.setText("340"); break;
            case 3: viewlibro.setImage(odisea); libro="La Odisea"; txtprecio.setText("180"); break;
            case 4: viewlibro.setImage(hamlet); libro="Hamlet"; txtprecio.setText("210"); break;
        }
    }

    public void imgjuv(ActionEvent event){
        int x=combojuvenil.getSelectionModel().getSelectedIndex();
        switch (x){
            case 0: viewlibro.setImage(hp); libro="Harry Potter y las Reliquias de la Muerte"; txtprecio.setText("450"); break;
            case 1: viewlibro.setImage(maze); libro="Maze Runner: Correr o morir"; txtprecio.setText("240"); break;
            case 2: viewlibro.setImage(ola); libro="La quinta ola"; txtprecio.setText("380"); break;
            case 3: viewlibro.setImage(juegos); libro="Los juegos del hambre"; txtprecio.setText("300"); break;
            case 4: viewlibro.setImage(estrella); libro="Bajo la misma estrella"; txtprecio.setText("290"); break;
        }
    }

    public void agregar(ActionEvent event){

        if (viewlibro.getImage()==null||txtcantidad.getText().equals("")){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Completar datos");
            alert.show();
        }else {
            pilalibro.add(new Libro(libro,Integer.parseInt(txtcantidad.getText()),Double.parseDouble(txtprecio.getText())));

            lista.getItems().add(pilalibro.peek().cantidad+" ejemplar(es) de -"+pilalibro.peek().titulo+"- "+pilalibro.peek().cantidad+" X $"+pilalibro.peek().precio);

            viewlibro.setImage(null);
            txtcantidad.setText("");
            txtprecio.setText("");
            btmandar.setDisable(false);

            if (contador<arregloLibro.length){
                lista2.getItems().add(pilalibro.peek().titulo+" "+pilalibro.peek().precio);
                arregloLibro[contador]=new Libro(libro,0,pilalibro.peek().precio);
                contador++;
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Registro superior lleno");
                alert.show();
            }


        }



    }

    public void retirar(ActionEvent event){
        if (pilalibro.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No hay elementos para remover");
            alert.show();
        }else {
            pilalibro.pop();
            int x = pilalibro.size();
            lista.getItems().remove(x);
            if (pilalibro.isEmpty()){btmandar.setDisable(true);}
        }


    }

    public void mandar(ActionEvent event){
        double suma=0;
        while (!pilalibro.isEmpty()){
            suma = suma+(pilalibro.peek().precio*pilalibro.peek().cantidad);
            pilalibro.pop();
        }
        lista.getItems().clear();
        colaorden.add(suma);
        txtorden.setText(colaorden.size()+"");
        txttotal.setText(colaorden.peek()+"");
        btpagar.setDisable(false);
        if (pilalibro.isEmpty()){btmandar.setDisable(true);}

        if (contador2<arregloOrden.length){
            lista3.getItems().add(suma);
            arregloOrden[contador2]= suma;
            contador2++;
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Registro de ordenes lleno");
            alert.show();
        }
    }

    public void pagar(ActionEvent event){
        colaorden.poll();
        txtorden.setText(colaorden.size()+"");
        txttotal.setText(colaorden.peek()+"");
        if (colaorden.isEmpty()){btpagar.setDisable(true);
            txtorden.setText("");
            txttotal.setText("");}
    }

    public void ordenar(ActionEvent event){
        if (contador==arregloLibro.length){
            Libro[] arreglo=Ordenamiento.burbuja(arregloLibro);
            lista2.getItems().clear();
            for (int x=0;x<arreglo.length;x++){
                lista2.getItems().add(arreglo[x].titulo+" "+arreglo[x].precio);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Favor de llenar el registro");
            alert.show();
        }
    }

    public void buscar(ActionEvent event){

        if (contador==arregloLibro.length){
            Libro[] arreglo=Ordenamiento.burbuja(arregloLibro);
            Busqueda busqueda = new Busqueda();
            if (numerobuscar.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ingresar una cantidad para buscar");
                alert.show();
            }else {
                int indice = busqueda.binaria(arreglo,arreglo.length,Double.parseDouble(numerobuscar.getText()));
                if (indice>=0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Libro encontrado");
                    alert.setContentText("El precio (cantidad) pertenece a el libro: "+arreglo[indice].titulo);
                    alert.show();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Libro no encontrado");
                    alert.setContentText("El precio (cantidad) no se encuentra en el registro");
                    alert.show();
                }
                lista2.getItems().clear();
                for (int x=0;x<arreglo.length;x++){
                    lista2.getItems().add(arreglo[x].titulo+" "+arreglo[x].precio);
                }
                lista2.getSelectionModel().select(indice);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Favor de llenar el registro");
            alert.show();
        }

    }

    public void ordenar2(ActionEvent event){
        if (contador2==arregloOrden.length){
            Double[] arreglo=Ordenamiento.shell(arregloOrden);
            lista3.getItems().clear();
            for (int x=0;x<arreglo.length;x++){
                lista3.getItems().add(arreglo[x]);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Favor de llenar el registro");
            alert.show();
        }

    }
}
