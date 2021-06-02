package com.main;

/**************************  LinkedList.java ********************************/

/** Implementation des Interface Liste mithilfe von Verkettung
*/

public class LinkedList implements List {

    private Eintrag anf;                     // zeigt auf nullten ListenEintrag
    private Eintrag pos;                     // zeigt vor aktuellen Listeneintrag

    public LinkedList() {                    // kreiert eine leere Liste
        pos = anf = new Eintrag();
        anf.next  = null;
    }

    public boolean empty() {                 // true, wenn Liste leer
        return anf.next == null;
    } 

    public boolean endpos() {                // true, wenn am Ende 
        return pos.next == null;
    }

    public void reset() {                    // rueckt an Anfang
        pos = anf;
    }

    public void advance() {                  // rueckt in Liste vor
        if (endpos()) 
        throw new RuntimeException(" am Ende der Liste ");
        pos = pos.next;
    }

    public Object elem() {                   // liefert aktuelles Element
        if (endpos()) 
        throw new RuntimeException(" am Ende der Liste ");
        return pos.next.inhalt;
    }

    public void insert(Object x) {           // fuegt ListenEintrag ein
        Eintrag hilf = new Eintrag();        // Das neue Listenelement
        hilf.inhalt  = x;                    // kommt vor das aktuelle
        hilf.next    = pos.next;
        pos.next     = hilf;
    }

    public void delete() {                   // entfernt aktuelles Element
        if (endpos()) 
        throw new RuntimeException(" am Ende der Liste ");
        pos.next = pos.next.next;
    }
}
