package tests.com.venktesh.datastructures.linkedlist;

import static org.junit.Assert.*;

import com.venktesh.datastructures.linkedlist.SinglyLinkedList;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.*;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> list;

  @Before
  public void setup() {
    list = new SinglyLinkedList<>();
  }

  @Test
  public void testEmptyList() {
    assertTrue(list.isEmpty());
    assertEquals(list.size(), 0);
  }

  @Test(expected = Exception.class)
  public void testRemoveFirstOfEmpty() {
    list.removeLast();
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

    SinglyLinkedList<String> strs = new SinglyLinkedList<>();
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
    System.out.println("list" + strs.toString());
    strs.remove("c");
    System.out.println("list" + strs.toString());
    strs.remove("f");
    assertEquals(0, strs.size());
  }
}