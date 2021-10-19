/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Alumno
 */
public class Practica03 extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox left = new VBox();
        VBox right = new VBox();
        HBox root = new HBox(left, right);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("VBox Layout");
        primaryStage.setScene(scene);
        primaryStage.show();

        Label labelTitle = new Label("Login");
        labelTitle.setFont(new Font(30));

        Label labelUser = new Label("Usuario");
        labelUser.setFont(new Font(15));

        Label labelPassword = new Label("Contraseña");
        labelPassword.setFont(new Font(15));
        TextField textUser = new TextField();
        textUser.setMaxWidth(150);

        PasswordField textPass = new PasswordField();
        textPass.setMaxWidth(150);

        Button btnLogin = new Button("Entrar");
        btnLogin.setMaxWidth(150);
        btnLogin.setCursor(Cursor.HAND);

        left.getChildren().addAll(labelTitle, labelUser, textUser,
                labelPassword, textPass, btnLogin);
        left.setAlignment(Pos.CENTER);

        VBox.setMargin(labelUser, new Insets(5, 0, 0, 20));
        VBox.setMargin(labelPassword, new Insets(5, 0, 0, 20));
        VBox.setMargin(btnLogin, new Insets(5, 0, 0, 20));
        VBox.setMargin(textUser, new Insets(5, 0, 0, 20));
        VBox.setMargin(textPass, new Insets(5, 0, 0, 20));
        
        Image image = new Image(getClass().getResourceAsStream("/imagenes/imagen.jpg"));
        ImageView imageLogo = new ImageView(image);
        imageLogo.setFitHeight(200);
        imageLogo.setFitWidth(300);
        VBox.setMargin(imageLogo, new Insets(0, 0, 0, 30));
        
        
        right.getChildren().addAll(imageLogo);
        right.setAlignment(Pos.CENTER);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
