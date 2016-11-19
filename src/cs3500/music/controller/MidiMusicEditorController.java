package cs3500.music.controller;

import java.util.ArrayList;

import cs3500.music.model.ANote;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.INoteType;
import cs3500.music.view.IMusicEditorView;

/**
 * A controller specifically for playing a music model with a midi interface.
 */
public class MidiMusicEditorController implements IMusicEditorController {
  IMusicEditorModel model;
  IMusicEditorView view;

  /**
   * Initialises the controller object.
   *
   * @param model the model for the controller.
   * @param view the view for the controller.
   */
  public MidiMusicEditorController(IMusicEditorModel model, IMusicEditorView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    int songLength = this.model.length();
    int curBeat = 0;
    while (true) {
      ArrayList<ANote> notesAtBeat = this.model.getAtBeat(curBeat);

      // Uncomment the following line to print notes to the console as it is played (for fun!)
      //System.out.print(getString(notesAtBeat) + "\n");

      for (ANote n : notesAtBeat) {
        if (n.whichType() == INoteType.NOTE) {
          this.view.renderNote((n.getPitch() + n.getBaseInterval() * 12), 90, n.getDuration(), n.getInstrument(), n.getBeat());
        }
      }
      curBeat = curBeat + 1;
      if (curBeat >= songLength) {
        //curBeat = 0; // Loops song indefinitely
        try {
          Thread.sleep((this.view.getTempo() / 1000) * 3);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return;   // Uncomment this to end playback after first loop
      }
      try {
        Thread.sleep(this.view.getTempo() / 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Makes notes into string for displaying.
   *
   * @param notesAtBeat the beat to get notes from.
   * @return the string of notes.
   */
  static String getString(ArrayList<ANote> notesAtBeat) {
    String line = "";
    for (ANote n : notesAtBeat) {
      line += n.toString().substring(2, 3);
    }
    return line;
  }
}
