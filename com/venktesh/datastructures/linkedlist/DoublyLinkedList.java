package com.venktesh.datastructures.linkedlist;

import javax.management.RuntimeErrorException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
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
            head = tail = new Node<T>(element, null,null);
        }
        else {
            head.prev = new Node<T>(element, null, head);
            head = head.prev;
        }
        size++;
    }


    public void addElementAfterTail(T element) {
        if(isEmpty()) {
            head = tail = new Node<T>(element, null,null);
        }
        else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("List is Empty");
        T data = head.data;
        head = head.next;
        --size;
        if(isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    public T removeLast() {
        if(isEmpty())
            throw new RuntimeException("List is empty");
        T data = tail.data;
        tail = tail.prev;
        --size;
        if(isEmpty()) head = null;
        else tail.next = null;
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
        if(node.prev == null)
            return removeFirst();
        if(node.next == null) {
          return removeLast();
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
        T data = node.data;
        node.data = null;
        node = node.prev = node.next =null;
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
            sb.append("<->");
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