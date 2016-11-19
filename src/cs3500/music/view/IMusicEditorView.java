package cs3500.music.view;

/**
 * Represent a music editor view.
 */
public interface IMusicEditorView {
  /**
   * Render a particular note in the view.
   * @param rawPitch Raw pitch number of note
   * @param volume volume of note
   * @param duration Duration of note
   */
  void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum);

  void setTempo(int tempo);

  int getTempo();
}
