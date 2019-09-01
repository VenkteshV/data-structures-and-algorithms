package com.venktesh.datastructures.linkedlist;

import javax.management.RuntimeErrorException;

public class SinglyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size() ==0;
    }

    public void addElementAtHead(T element) {
        if(isEmpty()) {
            head = tail = new Node<T>(element,null);
        }
        else {
            Node<T> newNode = new Node<T>(element, head);
            head = newNode;
        }
        size++;
    }


    public void addElementAfterTail(T element) {
        if(isEmpty()) {
            head = tail = new Node<T>(element,null);
        }
        else {
            tail.next = new Node<T>(element, null);
            tail = tail.next;
        }
        size++;
    }

    public T removeLast() {
        if(isEmpty())
            throw new RuntimeException("List is empty");
        Node<T> traverser = head;
        if(head.data == tail.data) {
            T data = tail.data;
            head = tail = null;
            return data;
        }
        while(traverser.next != tail) {
            traverser = traverser.next;
        }
        T data = tail.data;
        tail = traverser;
        tail.next = null;
        --size;
        return data;

        
    }

    public T peekFirst() {
      return head.data;
    }

    public boolean remove(Object obj) {

        Node<T> trav = head;
    
        if (obj == null) {
          for (trav = head; trav != null; trav = trav.next) {
            if (trav.data == null) {
              remove(trav);
              return true;
            }
          }
        } else {
          for (trav = head; trav != null; trav = trav.next) {
            if (obj.equals(trav.data)) {
              remove(trav);
              return true;
            }
          }
        }
        return false;
      }

    private T remove (Node<T> node) {
        T data = node.data;
        if(node.next == null)
            removeLast();

        else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
        --size;
        return data;
    }

    @Override
    public String toString() {
        Node<T> traverser = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(traverser!=null) {
            sb.append(traverser.data);
            sb.append("->");
            traverser = traverser.next;
        }
        sb.append("null]");
        return sb.toString();
    }


  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private Node<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

}