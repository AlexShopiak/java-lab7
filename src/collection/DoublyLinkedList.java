/*
 * DoublyLinkedList
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * Doubly linked list and Node
 */
package collection;

class Node { 
    Node prev; 
    int data; 
    Node next; 

    Node(int value) { 
        prev = null; 
        data = value; 
        next = null; 
    } 
} 
  
class DoublyLinkedList { 
    Node head = null; 
    Node tail = null; 

    void insertAtBeginning(int data) { 
        Node temp = new Node(data); 
        if (head == null) { 
            head = temp; 
            tail = temp; 
        } else { 
            temp.next = head; 
            head.prev = temp; 
            head = temp; 
        } 
    } 
  
    void insertAtEnd(int data) { 
        Node temp = new Node(data); 
        if (tail == null) { 
            head = temp; 
            tail = temp; 
        } else { 
            tail.next = temp; 
            temp.prev = tail; 
            tail = temp; 
        } 
    } 
  
    void insertAtPosition(int data, int position) { 
        Node temp = new Node(data); 
        if (position == 1) { 
            insertAtBeginning(data); 
        } else { 
            Node current = head; 
            int currPosition = 1; 
            while (current != null
                   && currPosition < position) { 
                current = current.next; 
                currPosition++; 
            } 

            if (current == null) { 
                insertAtEnd(data); 
            } else { 
                temp.next = current; 
                temp.prev = current.prev; 
                current.prev.next = temp; 
                current.prev = temp; 
            } 
        } 
    } 
  
    void deleteAtBeginning() { 
        if (head == null) { 
            return; 
        } 
  
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        } 
  
        Node temp = head; 
        head = head.next; 
        head.prev = null; 
        temp.next = null; 
    } 
  
    void deleteAtEnd() { 
        if (tail == null) { 
            return; 
        } 
  
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        } 
  
        Node temp = tail; 
        tail = tail.prev; 
        tail.next = null; 
        temp.prev = null; 
    } 
  
    void deleteAtSpecificPosition(int pos) { 
        if (head == null) { 
            return; 
        } 
  
        if (pos == 1) { 
            deleteAtBeginning(); 
            return; 
        } 
  
        Node current = head; 
        int count = 1; 
  
        while (current != null && count != pos) { 
            current = current.next; 
            count++; 
        } 
  
        if (current == null) { 
            System.out.println("Position wrong"); 
            return; 
        } 
  
        if (current == tail) { 
            deleteAtEnd(); 
            return; 
        } 
  
        current.prev.next = current.next; 
        current.next.prev = current.prev; 
        current.prev = null; 
        current.next = null; 
    } 
  
    void display(Node head) { 
        Node temp = head; 
        while (temp != null) { 
            System.out.print(temp.data + " --> "); 
            temp = temp.next; 
        } 
        System.out.println("NULL"); 
    }
}
