/*
 * StoneSet
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * It is a typed set of Stone ojects 
 * which has doubly linked array structure
 */
package collection;

import java.util.Collection;
import java.util.Iterator;
import stone.Stone;

public class StoneSet extends StoneDoublyLinkedList{ 
    public StoneSet() {}

    public StoneSet(Stone element) {
        add(element);
    }

    public StoneSet(Collection<Stone> collection) throws NullPointerException {
        addAll(collection);
    }

    public boolean add(Stone element) {
        if (contains(element)) {
            return false;
        } else {
            insertAtEnd_DLL(element);
            return true;
        }
    }

    public boolean addAll(Collection<Stone> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean oneAdded = false;
        Iterator<Stone> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            boolean addition = add(stone);
            if (addition == true) {
                oneAdded = true;
            }
        }

        return oneAdded;
    }

    public void clear() {
        clear_DLL();
    }

    public boolean contains(Stone element) {
        Node current = head; 
        while (current != null) { 
            Stone stone = current.data;
            if (stone.equals(element)) {
                return true;
            }
            current = current.next; 
        }

        return false;
    }

    public boolean containsAll(Collection<Stone> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException();
        }

        Iterator<Stone> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            boolean containing = contains(stone);
            if (containing == false) {
                return false;
            }
        }

        return true;
    }

    public boolean equals(Object o) {
        return hashCode() == o.hashCode();
    }

    public int hashCode() {
        int sum = 0; 

        Node current = head;
        while (current != null) { 
            Stone stone = current.data;
            sum += (stone != null ? stone.hashCode() : 0);
            current = current.next; 
        }

        return sum;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<Stone> iterator() {
        return new Iterator_DLL();
    }

    public boolean remove(Stone element) {
        Node current = head; 
        int pos = 0;

        while (current != null) { 
            Stone stone = current.data;
            if (stone.equals(element)) {
                deleteAtSpecificPosition_DLL(pos);
                System.out.println("Pos:"+pos);
                return true;
            }
            current = current.next; 
            pos++;
        }

        return false;
    }

    public boolean removeAll(Collection<Stone> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean changed = false;

        Iterator<Stone> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            boolean removing = remove(stone);
            if (removing == true) {
                changed = true;
            }
        }

        return changed;
    }

    public boolean retainAll(Collection<Stone> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean changed = false;
        int pos = 0;

        Node current = head; 
        while (current != null) { 
            Stone stone = current.data;
            if (!collection.contains(stone)) {
                deleteAtSpecificPosition_DLL(pos);
                changed = true;
                pos--;
            }
            current = current.next; 
            pos++;
        }

        return changed;    
    }

    public int size() {
        return size_DLL();
    }

    public Stone[] toArray() {
        int size = size();
        Stone[] stones = new Stone[size];
        Node current = head;

        for (int i = 0; i < size; i++) {
            stones[i] = current.data;
            current = current.next;
        }

        return stones;
    }

    public Stone[] toArray(Stone[] array) {
        return toArray();
    }
}
