package cs3500.music.controller;

import java.util.ArrayList;

import cs3500.music.model.ANote;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.INoteType;
import cs3500.music.view.IMusicEditorView;

/**
 * Represent a GUI/MIDI editor controller
 */
public class GuiMidiEditorController implements IMusicEditorController {
  IMusicEditorModel model;
  IMusicEditorView view;

  /**
   * Initialises the controller object.
   *
   * @param model the model for the controller.
   * @param view the view for the controller.
   */
  public GuiMidiEditorController(IMusicEditorModel model, IMusicEditorView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    int numBeats = model.length();

    for (int i = 0; i < numBeats; ++i) {
      ArrayList<ANote> notes = model.getAtBeat(i);
      for (int j = 0; j < notes.size(); ++j) {
        ANote note = notes.get(j);
        if (note.whichType() == INoteType.NOTE) {
          view.renderNote(j, 1, note.getDuration(), note.getInstrument(), i);
        }
      }
    }
  }
}
