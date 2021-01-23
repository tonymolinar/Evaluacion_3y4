package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Controller {

    @FXML Button bingresar;
    @FXML TextField tusuario;
    @FXML PasswordField pass;
    @FXML ImageView avatar;
    @FXML ImageView datos;

    String[][] arregloUsuario = new String[3][2];

    @FXML protected void initialize(){
        arregloUsuario[0][0]="user2"; arregloUsuario[0][1]="password2";
        arregloUsuario[1][0]="user1"; arregloUsuario[1][1]="password1";
        arregloUsuario[2][0]="user"; arregloUsuario[2][1]="password";
    }

    Image imgdatos = new Image("file:src/sample/Img/datos.png");

    public void ingresar(ActionEvent event) throws IOException {

        Busqueda busqueda = new Busqueda();
        int indice = busqueda.secuencial(arregloUsuario,tusuario.getText(),pass.getText());

        if (indice>=0){
            Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            Main.stage.setScene(new Scene(root,1250,600));
            Main.stage.setResizable(false);
            Main.stage.setX(0);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Datos inválidos");
            alert.show();
        }

    }

    public void mostrar(){
        datos.setImage(imgdatos);
    }

    public void ocultar(){
        datos.setImage(null);
    }

}
