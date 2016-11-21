package cs3500.music.view;

import cs3500.music.controller.KeyboardHandler;

/**
 * Interface for visually representing a piece of music. Also provides methods for
 * user to provide input to edit notes.
 */
public interface GuiView extends IMusicEditorView {

  /**
   * Adds a keyboard listener to the view.
   * @param handler the key listener.
   */
  void keyboardCallback(KeyboardHandler handler);

  /**
   * Set the current beat of playback.
   * @param beat the current beat.
   */
  void setBeat(int beat);

  /**
   * Scroll the view horizontally.
   * @param toScroll the number of pixels to scroll.
   */
  void scroll(int toScroll);

  /**
   * Get the lowest note of the composition.
   * @return the value of the lowest note.
   */
  int getLowestNote();

  /**
   *  Get the command entered by the user.
   * @return the string entered.
   */
  String getTextInput();

  /**
   * Refresh the frame.
   * @param noteChange option to reload all notes in view.
   */
  void update(boolean noteChange);
}

