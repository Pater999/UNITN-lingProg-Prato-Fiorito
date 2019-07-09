# UNITN-lingProg-Prato-Fiorito
Università di Trento - Soluzione compito di Linguaggi di Programmazione, Modulo 1 – gennaio 2019

:fire: Esempio di soluzione da me realizzata per l'esame di Ronchetti di gennaio 2019.

## Testo:
1. Si costruisca un'applicazione che presenta
    * una scacchiera NxN (*inizialmente si assuma N=4*)
    * un contatore di punti (*inizialmente posto a zero*)
    * un campo che mostra il numero di partite vinte (*inizialmente a zero*)
    * un tasto "reset"
    * un tasto "cheat"
    
<p align="center">
  <img src="https://user-images.githubusercontent.com/39135429/60907714-830eb600-a27a-11e9-9379-b94a4604c486.png" alt="esempio">
</p>

2. Si produca su un foglio il diagramma UML di tutte le classi coinvolte. Non serve mostrare le classi di JavaFX, eccetto quelle da cui le classi scritte dal programmatore ereditano direttamente, se ve ne sono, Al termine, il foglio (sul quale devono essere presenti nome, cognome, numero di matricola) dovrà essere consegnato. 

3. Ciascuna cella della scacchiera può ospitare una tessera. Ogni tessera può essere nello stato "coperto" o "scoperto". In stato scoperto mostra il proprio valore, in stato coperto mostra solo il proprio dorso di colore uniforme. <br>
Le tessere sono di vario tipo:
    1. Tipo V: "Vinci subito" 
    2. Tipo p: "Perdi subito" 
    3. Tipo S: numerico, con valori compresi tra 1 e 9. <br>
    4. Tutte le tessere, indipendentemente dal tipo, eseguono il metodo "scopri()", nel momento in cui vengono scoperte, e il metodo "nascondi()" se e quando vengono ricoperte. 
    
4. Per le tessere di tipo P, il metodo "scopri()" apre una finestra modale nella quale appare la scritta "**Peccato, hai perso!**"; tale messaggio viene altresi stampato sulla console. La finestra contiene un bottone di "OK", schiacciando il quale la finestra viene chiusa e il programma termina.

5. Per le tessere di tipo V, il metodo "scopri()" apre una finestra modale nella quale appare la scritta "**Complimenti, hai vinto!**"; tale messaggio viene altresi stampato sulla console. La finestra contiene un bottone di "OK", schiacciando il quale la finestra viene chiusa. Il contatore "partite vinte" viene incrementato di uno, il programma ripristina lo stato iniziale (eccetto che per il contatore "partite vinte") e il giocatore può procedere con una nuova partita.

6. Per le tessere di tipo S, il metodo "scopri()" legge il valore della tessera e lo aggiunge al contatore di punti. II valore della tessera e il nuovo valore del contatore di punti vengono altresi stampati sulla console. Se il punteggio totale risultante è <10, il colore del punteggio é mostrato in **blu**, se è >10 il colore é **rosso**. Se invece il punteggio risulterå esattamente uguale a 10, il punteggio verrà mostrato in verde, e viene aperta una finestra di vittoria uguale a quella del **punto 5**, e si procede come in quel caso.

7. All'inizio, vengono generate: una tessera di tipo V, una tessera di tipo P, tessere di tipo S in numero pari a (NxN)-2. Ciascuna tessera di tipo S avrà un valore casuale compreso tra 1 e 9: ovviamente vi potranno essere più tessere di valore uguale. Le tessere così generate vengono disposte in ordine casuale sulla scacchiera in stato "coperto" ed in modo tale da coprire tutte le celle. Una rappresentazione testuale equivalente della scacchiera viene altresi stampata sulla console.

8. Ciascuna tessera può essere scoperta cliccando su di essa (e quindi attivando il relativo metodo "scopri()").

9. Le tessere possono essere cliccate anche se sono scoperte, attivandone in questo modo il metodo "nascondi()": esse diventano coperte, per le tessere di tipo S il loro valore viene detratto dal contatore di punti cambiandone il colore e procedendo all'eventuale proclamazione di vittoria come al punto **punto 5**.

10. Il tasto di reset ripristina il gioco al suo stato iniziale.

11. II tasto "cheat" apre una finestra nella quale vengono stampati i valori delle tessere nell'ordine in cui sono disposte sulla scacchiera, indicando rispettivamente con V e P le tessere di questi tipi, ed il valore numerico per le tessere di tipo S. *Nota: in alternativa, questo output può essere dato in console, pagando una piccola penalitå nella valutazione del compito*.

12. Si introduca a inizio gioco la richiesta all'utente del valore del parametro N di cui al punto 1. Tale valore dovrà essere compreso tra 3 e 9. Si gestisca il caso di risposta non valida. Si usi il parametro N per il dimensionamento della scacchiera e la determinazione del numero delle tessere. E' possibile effettuare tale richiesta come si preferisce. II consiglio è comunque di includere nel proprio codice la seguente riga: <br>
<span style="font-family:Courier New;"> *String response=InputDialog.getResponse();* </span><br>
e includere nel progetto la seguente classe:<p style="font-family:Courier New;">
        *TextInputDialog dialog = new TextInputDialog();<br>
        dialog.setHeaderText("Dimensione della griglia???");<br>
        dialog.setTitle("Dimensione griglia");<br>
        dialog.setContentText("Inserire NUMERO compreso tra 3 e 9:   ");<br>
        Optional<String> result = dialog.showAndWait();<br>
        if(result.isPresent())<br>
            return result.get();<br>
        else<br>
            return null;<br>*
 </p>
  
## In questo progetto sono stati svolti i punti:
- [x] 1. Si costruisca un’applicazione avente il seguente aspetto
- [ ] 2. Si produca su un foglio il diagramma UML di tutte le classi coinvolte.
- [x] 3-4-5-6-7-8-9-10-11-12
