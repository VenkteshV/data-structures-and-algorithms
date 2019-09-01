package tests.com.venktesh.datastructures.linkedlist;

import static org.junit.Assert.*;

import com.venktesh.datastructures.linkedlist.DoublyLinkedList;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.*;

public class DoublyLinkedlisttest {

  DoublyLinkedList<Integer> list;

  @Before
  public void setup() {
    list = new DoublyLinkedList<>();
  }

  @Test
  public void testEmptyList() {
    assertTrue(list.isEmpty());
    assertEquals(list.size(), 0);
  }

  @Test(expected = Exception.class)
  public void testRemoveFirstOfEmpty() {
    list.removeFirst();
  }

  @Test 
  public void testAdd() {
    list.addElementAfterTail(2);
    list.addElementAfterTail(3);
    list.addElementAfterTail(8);
    System.out.println("list" + list.toString());
    assertTrue(list.peekFirst() ==2);
  }

  @Test
  public void testRemoving() {

    DoublyLinkedList<String> strs = new DoublyLinkedList<>();
    strs.addElementAfterTail("a");
    strs.addElementAfterTail("b");
    strs.addElementAfterTail("c");
    strs.addElementAfterTail("d");
    strs.addElementAfterTail("e");
    strs.addElementAfterTail("f");
    strs.remove("b");
    strs.remove("a");
    strs.remove("d");
    strs.remove("e");
    strs.remove("c");
    strs.remove("f");
    assertEquals(0, strs.size());
  }
}