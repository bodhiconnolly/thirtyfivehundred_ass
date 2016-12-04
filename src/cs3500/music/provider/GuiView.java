package cs3500.music.provider;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Interface for GUI views of MIDI.
 */
public interface GuiView extends IView {
  int NOTE_SIZE = 12;

  /**
   * Toggles pause and play for this provider.
   */
  void pausePlay();

  /**
   * Makes the provider return to the start of the piece.
   */
  void goToStart();

  /**
   * Makes the provider skip to the end of the piece.
   */
  void goToEnd();

  /**
   * Scrolls the gui to the left.
   */
  void scrollLeft();

  /**
   * Scrolls the gui to the right.
   */
  void scrollRight();

  /**
   * Adds the given keyListener.
   *
   * @param keyListener the key listener
   */
  void addKeyListener(KeyListener keyListener);

  /**
   * Adds the given mouseListener.
   *
   * @param mouseListener the mouse listener
   */
  void addMouseListener(MouseListener mouseListener);

  /**
   * Gets the pitch that the mouse is hovering over.
   *
   * @return The pitch the mouse is at.
   * @throws IllegalArgumentException If the mouse is out of bounds.
   */
  int getMousePitch() throws IllegalArgumentException;

  /**
   * Gets the beat that the mouse is hovering over.
   *
   * @return The beat the mouse is at.
   * @throws IllegalArgumentException If the mouse is out of bounds.
   */
  int getMouseBeat() throws IllegalArgumentException;

  /**
   * Refreshes the visual provider.
   */
  void refresh();
}
