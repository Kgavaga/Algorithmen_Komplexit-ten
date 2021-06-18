/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

/**
 *
 * @author kg200
 */
public class LinkedQueue implements Queue {

    Eintrag head;
    Eintrag tail;

    public LinkedQueue() {

    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public void enq(Object x) {
        if (head == null) {
            tail = new Eintrag();
            tail.inhalt = x;
            head = tail;
        } else {
            Eintrag temp = new Eintrag();
            tail.next = temp;
            tail = temp;
            tail.inhalt = x;
        }
    }

    @Override
    public Object front() {
        return head.inhalt;
    }

    @Override
    public void deq() {
        if(empty()) return;
        else if(head.next == null) head = tail = null;
        else head = head.next;
    }
    
    public void deqTail() {
        Eintrag temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        
    }

}
