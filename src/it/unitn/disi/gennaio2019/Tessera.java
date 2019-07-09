/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author matti
 */
public abstract class Tessera extends HBox {
    boolean isNascosta;
    int valore;
    
    public Tessera()
    {
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(30, 30);
        this.setStyle("-fx-background-color: yellow;-fx-border-color: black");
        isNascosta = true;
    }
    
    public abstract int scopri();
    
    public boolean isNascosta()
    {
        return isNascosta;
    }
    
    public int valore()
    {
        return valore;
    }

}
