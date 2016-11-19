package cs3500.music.view;


import cs3500.music.controller.KeyboardHandler;

/**
 * Created by Bodhi on 19/11/2016.
 */
public interface GuiView extends IMusicEditorView {

  void keyboardCallback(KeyboardHandler handler);
  void setBeat(int beat);
  void scroll(int toScroll);

}

