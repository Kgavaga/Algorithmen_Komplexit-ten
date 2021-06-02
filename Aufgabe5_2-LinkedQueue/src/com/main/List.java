package com.main;

/*****************************  List.java  ***********************************/

/** Interface fuer den ADT List                                              
 */

public interface List {

    public boolean empty();        // true: Liste leer, false: sonst
    public boolean endpos();       // true: Liste am Ende, false: sonst
    public void reset();           // gehe an Anfang der Liste
    public void advance();         // gehe in Liste eine Position weiter
    public Object elem();          // liefere Inhalt des aktuellen Elements 
    public void insert(Object x);  // fuege x vor aktuellem Element ein
                                   // und mache x zum aktuellen Element
    public void delete();          // entferne aktuelles Element und mache
                                   // seinen Nachfolger zum aktuellen Element
}
