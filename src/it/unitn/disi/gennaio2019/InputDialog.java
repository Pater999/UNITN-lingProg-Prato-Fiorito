/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author matti
 */
public class InputDialog {
    public static String getResponse()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Dimensione della griglia???");
        dialog.setTitle("Dimensione griglia");
        dialog.setContentText("Inserire NUMERO compreso tra 3 e 9:   ");
        Optional<String> result = dialog.showAndWait();
        if(result.isPresent())
            return result.get();
        else
            return null;
    }
}
