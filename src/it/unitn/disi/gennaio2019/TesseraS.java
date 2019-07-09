/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author matti
 */
public class TesseraS extends Tessera {
    final Random random = new Random();
    
    Label x;
   
    public TesseraS()
    {
        valore = random.nextInt(8)+1;
        x = new Label(Integer.toString(valore));
    }
    
    public int scopri()
    {
        isNascosta = false;
        this.setStyle("-fx-background-color:white;-fx-border-color: black");
        this.getChildren().add(x);
        return valore;
    }
    
    public int nascondi()
    {
        isNascosta = true;
        this.setStyle("-fx-background-color:green;-fx-border-color: black");
        this.getChildren().remove(x);
        return valore*-1;
    }
}
