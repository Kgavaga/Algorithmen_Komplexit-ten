package com.main;

import java.util.Scanner;

/***************************  LinkedQueueTest.java  *********************/

/**
* Programm zum Testen der Methoden des ADT Queue. Liest Zeichenketten und
* reiht sie in eine queue ein. Bei Eingabe einer leeren Zeichenkette wird
* die jeweils vorderste aus der Queue ausgegeben und entfernt.
*/

public class LinkedQueueTest
{

    public static void main(String argv[])
    {
        
        Queue queue = new LinkedQueue();   // konstruiere leere Queue
        
        System.out.println("Bitte Queue fuellen durch Eingabe eines Wortes, ");
        System.out.println("Queue-Kopf Entfernen durch Eingabe von RETURN.");
        
        do
        {
            System.out.print("Input: ");
            Scanner s = new Scanner(System.in);
            String eingabe = s.nextLine();
            
            if (eingabe.length() > 0)                // falls Eingabe != RETURN
            queue.enq(eingabe);                      // fuege in queue ein
            
            // falls EINGABE == RETURN
            else if (!queue.empty()){                // sofern queue nicht leer
                System.out.println("entfernt: " + queue.front());
                queue.deq();                         // entferne Frontelement
            }
        }
        while (!queue.empty());
        
        System.out.println("queue ist jetzt leer.");
    }
}

