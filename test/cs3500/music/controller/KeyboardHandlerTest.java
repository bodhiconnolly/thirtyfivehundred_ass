package cs3500.music.controller;

import org.junit.Test;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import static org.junit.Assert.assertTrue;

/**
 * Testing keyboard handler class.
 */
public class KeyboardHandlerTest {
  private boolean testVar;

  /**
   * Tests that keyboard handler runs correct runnable when key is pressed.
   */
  @Test
  public void runnableTest() {
    testVar = false;
    KeyboardHandler kH = new KeyboardHandler();
    kH.addRunnable(KeyEvent.VK_ENTER, () -> setTestVar());
    KeyEvent key = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, 'Z');
    ;
    kH.keyPressed(key);
    assertTrue(testVar);
  }

  private void setTestVar() {
    testVar = true;
  }

}