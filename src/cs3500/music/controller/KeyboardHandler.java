package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * Created by Bodhi on 19/11/2016.
 */
public class KeyboardHandler implements KeyListener {

  Map<Integer, Runnable> mapping;

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  public void addRunnable(Integer keyCode, Runnable runner){
    mapping.put(keyCode, runner);
  }
}
