package cs3500.music.controller;

import java.util.ArrayList;

import cs3500.music.model.ANote;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.INoteType;
import cs3500.music.view.GuiView;

/**
 * A controller object specifically for rendering a music model in a GUI.
 */
public class GuiMusicController implements IMusicEditorController {
  private IMusicEditorModel model;
  private GuiView view;
  private KeyboardHandler keyboardHandler;

  /**
   * Initialises a Gui Controller object.
   *
   * @param model the model for the controller.
   * @param view  the view for the controller.
   */
  public GuiMusicController(IMusicEditorModel model, GuiView view) {
    this.model = model;
    this.view = view;

    //keyboardHandler.addRunnable();
    this.view.keyboardCallback(this.keyboardHandler);


  }

  @Override
  public void go() {

    // Uncomment the following line to render the music editor in the model
    //System.out.print(model.toString());

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

    //view.setBeat(7);
  }
}
