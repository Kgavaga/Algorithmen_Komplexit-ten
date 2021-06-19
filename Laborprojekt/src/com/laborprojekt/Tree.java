package com.laborprojekt;
/********************************  Tree.java  *********************************/

/** Interface Tree 
*/

public interface Tree { 

    public boolean empty();                  // liefert true, falls Baum leer ist
    public Tree left();                      // liefert linken Teilbaum
    public Tree right();                     // liefert rechten Teilbaum
    public boolean isLeaf();				 // liefert true, falls Baum ein Blatt ist
    public Object value();                   // liefert Objekt in der Wurzel

}
