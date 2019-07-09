/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 *
 * @author matti
 */
public class TesseraP extends Tessera{
    public TesseraP()
    {
        valore = -1;
    }
    
    public int scopri()
    {
        isNascosta = false;
        this.setStyle("-fx-background-color:grey;-fx-border-color: black");
        this.getChildren().add(new Label("P"));
        return -1;
    }
}
