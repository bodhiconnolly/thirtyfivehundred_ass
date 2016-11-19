package cs3500.music.view;

import java.util.ArrayList;

import cs3500.music.model.ANote;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.INoteType;

/**
 * Created by Bodhi on 7/11/2016.
 */
public class ConsoleView implements IMusicEditorView {
  private IMusicEditorModel model;

  public ConsoleView(IMusicEditorModel model) {
    this.model = model;
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    System.out.print(model.toString());
  }

  @Override
  public void setTempo(int tempo) {

  }

  @Override
  public int getTempo() {
    return 0;
  }

}
