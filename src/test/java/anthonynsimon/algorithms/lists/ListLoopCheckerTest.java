package anthonynsimon.algorithms.lists;

import anthonynsimon.datastructures.SinglyNode;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListLoopCheckerTest {
  
  private ListLoopChecker<String> classUnderTest = new ListLoopChecker<>();
  
  @Test
  public void testEmptyList() {
    SinglyNode<String> head = null;
    assertEquals(classUnderTest.listHasLoopAt(head), null);
  }
  
  @Test
  public void testOneNodeList() {
    SinglyNode<String> head = new SinglyNode<>("a");
    assertEquals(classUnderTest.listHasLoopAt(head), null);
  }
  
  @Test
  public void testOneNodeListWithLoop() {
    SinglyNode<String> head = new SinglyNode<>("a");
    
    head.setNext(head);
    
    assertEquals(classUnderTest.listHasLoopAt(head), head);
  }
  
  @Test
  public void testThreeNodeListWithLoop() {
    SinglyNode<String> head = new SinglyNode<>("a");
    SinglyNode<String> middle = new SinglyNode<>("b");
    SinglyNode<String> tail = new SinglyNode<>("c");
    
    head.setNext(middle);
    middle.setNext(tail);
    tail.setNext(middle);
    
    assertEquals(classUnderTest.listHasLoopAt(head), middle);
  }
  
  @Test
  public void testLongerListNoLoop() {
    String[] values = {"a", "b", "c", "d", "e", "f", "g"};
    
    SinglyNode<String> head = new SinglyNode<>(values[0]);
    
    SinglyNode<String> current = head;
    for (int i = 1; i < values.length; i++) {
      current.setNext(new SinglyNode<String>(values[i]));
      current = current.getNext();
    }
    
    assertEquals(classUnderTest.listHasLoopAt(head), null);
  }
  
  @Test
  public void testLongerListWithLoop() {
    String[] values = {"a", "b", "c", "d", "e", "f", "g"};
    
    SinglyNode<String> head = new SinglyNode<>(values[0]);
    
    SinglyNode<String> current = head;
    for (int i = 1; i < values.length; i++) {
      current.setNext(new SinglyNode<String>(values[i]));
      current = current.getNext();
    }
    
    current.setNext(head);
    
    assertEquals(classUnderTest.listHasLoopAt(head), head);
    
    current.setNext(head.getNext());
    
    assertEquals(classUnderTest.listHasLoopAt(head), head.getNext());
  }
}