/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.gennaio2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author matti
 */
public class Scacchiera extends GridPane implements Cloneable {
    
    ArrayList<Tessera> tessere;
    int n;
    int nxn;
    EventHandler eventhandler;
    
    public Scacchiera(int N, EventHandler eh)
    {
        this.setAlignment(Pos.CENTER);
        tessere = new ArrayList<Tessera>();
        eventhandler = eh;
        n = N;
        nxn = N*N;
        generaTessere();
        
        riempiScacchiera();     
    }
    
    private void riempiScacchiera()
    {
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                this.add(tessere.get(index),j,i);
                index++;
            }
        }
    }
    
    private void generaTessere()
    {
        Tessera tmp;
        tmp = new TesseraV();
        tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventhandler);
        tessere.add(tmp);
        tmp = new TesseraP();
        tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventhandler);
        tessere.add(tmp);
        for (int i = 0; i < nxn - 2; i++)
        {
            tmp = new TesseraS();
            tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventhandler);
            tessere.add(tmp);
        }
        Collections.shuffle(tessere);
    }
    
    @Override
    public String toString()
    {
        int tmp;
        String s = "";
        for(int i = 0; i < nxn; i++)
        {
            tmp = tessere.get(i).valore();
            if(tmp == 0)
            {
                s+="V";
            }
            else if (tmp == -1)
            {
                s+="P";
            }else
            {
                s+=tmp;
            }
            s+= "\t";
            if((i+1) % n == 0)
            {
                s+="\n";
            }
        }
        return s;
    }
    
    
    
}



