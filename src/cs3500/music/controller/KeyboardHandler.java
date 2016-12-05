package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Keyboard listener for getting input to view.
 */
public class KeyboardHandler implements KeyListener {

  private Map<Integer, Runnable> mapping = new HashMap<Integer, Runnable>();

  @Override
  public void keyTyped(KeyEvent e) {
    // no need for these events
  }

  @Override
  public void keyPressed(KeyEvent e) {
    char c = e.getKeyChar();
    System.out.print(c);
    Runnable toRun = mapping.get(e.getKeyCode());
    if (toRun != null) {
      toRun.run();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // no need for these events
  }

  /**
   * Add a key to listen for.
   * @param keyCode the key code.
   * @param runner the function to run.
   */
  public void addRunnable(Integer keyCode, Runnable runner) {
    //System.out.print(mapping);
    mapping.put(keyCode, runner);
  }
}
