/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author matti
 */
    public class PratoFiorito extends Application {
    
    Stage mainWindow = null;
    Scacchiera scacchiera;
    ValueBox txtContPunt;
    ValueBox txtContVitt ;
    BorderPane root;
    Alert alert;
    int n = 4;
    
    BorderPane prepareSceneContent()  {
        
        settaNumeroCelle();
        
        root = new BorderPane();
        HBox hbContatori = new HBox();
        Label lblContPunt = new Label("Punteggio:");
        Label lblContVitt = new Label("Partite vinte:");
        txtContPunt = new ValueBox("0");
        txtContVitt = new ValueBox("0");
        hbContatori.setSpacing(10);
        hbContatori.setAlignment(Pos.CENTER);
        hbContatori.getChildren().addAll(lblContPunt,txtContPunt,lblContVitt,txtContVitt);
        HBox hbInferiore = new HBox();
        hbInferiore.setAlignment(Pos.CENTER);
        hbInferiore.setSpacing(30);
        MyButton btnReset = new MyButton("Reset",false,new ListenerReset());
        MyButton btnCheat = new MyButton("Cheat",false,new ListenerCheat());
        hbInferiore.getChildren().addAll(btnReset,btnCheat);
        
        scacchiera = new Scacchiera(n, new ListenerScacchiera());
        
        root.setTop(hbContatori);
        root.setCenter(scacchiera);
        root.setBottom(hbInferiore);
        
        
        
        return root;
    }
    public void start(Stage primaryStage) {
        Scene scene = new Scene(this.prepareSceneContent(), 800, 500);
        mainWindow = primaryStage;
        primaryStage.setTitle("Prato Fiorito");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    class ListenerScacchiera implements EventHandler {
        public void handle(Event t) {
            Tessera tmp = (Tessera)t.getSource();
            if (tmp.isNascosta == true)
            {
                int result = tmp.scopri();
                if(result == -1)
                {
                    dichiaraSconfitta();
                    System.exit(0);
                }
                else if(result == 0)
                {
                    dichiaraVittoria();
                } else
                {
                txtContPunt.incrementa(result);
                verificaPunteggio();
                }
            }
            else
            {
                int res = ((TesseraS)tmp).nascondi();
                txtContPunt.incrementa(res);
                verificaPunteggio();
            }
            
        }
        
    }
    
    private void settaNumeroCelle()
    {
        boolean numeroValido = true;
        do
        {
            String response = InputDialog.getResponse();
            if (response != null)
            {
                try{
                    n = Integer.parseInt(response);
                    System.out.print(n);
                    if (n > 2 && n < 10)
                    {
                        numeroValido = false;
                    }
                    else
                    {
                        System.out.print("NUMERO FUORI RANGE");
                    }
                }
                catch (NumberFormatException nfe)
                {
                  System.out.println("ERRORE FORMATO");
                }           
            }
           
        }while(numeroValido);
    }
    
    private void verificaPunteggio()
    {
        if (txtContPunt.getNumero() > 10)
        {
            txtContPunt.setStyle("-fx-control-inner-background:red;");        }
        else if (txtContPunt.getNumero() < 10)
        {
            txtContPunt.setStyle("-fx-control-inner-background:blue;");
        }
        else
        {
            txtContPunt.setStyle("-fx-control-inner-background:green;");
            dichiaraVittoria();
        }
    }
    
    private void dichiaraVittoria()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("HAI VINTO");
        alert.setHeaderText("Complimenti, hai vinto!");
        alert.showAndWait();
        txtContVitt.incrementa(1);
        txtContPunt.setText("0");
        root.getChildren().remove(scacchiera);
        scacchiera = new Scacchiera(n, new ListenerScacchiera());
        root.setCenter(scacchiera);
        txtContPunt.setStyle("");
    }
    
    private void dichiaraSconfitta()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("HAI PERSO!");
        alert.setHeaderText("Peccato, hai perso!");
        alert.showAndWait();
        txtContPunt.setStyle("");
    }
    
    class ListenerReset implements EventHandler {
        public void handle(Event t) {
            txtContPunt.setStyle("");
            txtContPunt.setText("0");
            txtContVitt.setText("0");
            root.getChildren().remove(scacchiera);
            scacchiera = new Scacchiera(n, new ListenerScacchiera());
            root.setCenter(scacchiera);
        }
        
    }
    class ListenerCheat implements EventHandler {
        public void handle(Event t) {
            System.out.print("---------------------------");
            System.out.print(scacchiera);
            Label label = new Label(scacchiera.toString());
            label.setAlignment(Pos.CENTER);
            Scene sc = new Scene(label, 500, 200);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(sc);
            stage.setX(100);
            stage.setY(100);
            stage.initOwner(mainWindow);
            stage.show();
        }
        
    }
    
    class ValueBox extends TextField
    {
        public ValueBox(String text)
        {
            super(text);
            this.setPrefWidth(40);
            this.setDisable(true);
            this.setAlignment(Pos.CENTER);
        }
        
        public void incrementa(int numero)
        {
            int n = Integer.parseInt(this.getText());
            n += numero;
            this.setText(Integer.toString(n));
        }
        
        public int getNumero()
        {
            return Integer.parseInt(this.getText());
        }
    }
    
    class MyButton extends Button
    {
        public MyButton(String txt, boolean isDisabled, EventHandler eh)
        {
            super(txt);
            this.setDisable(isDisabled);
            this.addEventHandler(ActionEvent.ACTION, eh);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
