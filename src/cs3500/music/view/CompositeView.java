package cs3500.music.view;

import java.awt.*;

/**
 * Created by matteoalampi on 11/19/16.
 */
public class CompositeView implements IMusicEditorView {
  GuiView guiView;
  MidiViewImpl midiView;

  public CompositeView(GuiView guiView, MidiViewImpl midiView) {
    this.guiView = guiView;
    this.midiView = midiView;
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    guiView.renderNote(rawPitch, volume, duration, instrument, beatnum);
    midiView.renderNote(rawPitch, volume, duration, instrument, beatnum);
  }

  @Override
  public void setTempo(int tempo) {
    midiView.setTempo(tempo);
  }

  @Override
  public int getTempo() {
    return midiView.getTempo();
  }
}
