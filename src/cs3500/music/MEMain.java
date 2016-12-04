package cs3500.music;

import java.io.FileNotFoundException;

import cs3500.music.controller.IMusicEditorController;
import cs3500.music.controller.MusicEditorController;
import cs3500.music.model.Adapter;
import cs3500.music.model.DiatonicScale;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.IMusicEditorModelBuilder;
import cs3500.music.model.MusicEditorType;
import cs3500.music.model.IChart;
import cs3500.music.provider.IView;
import cs3500.music.provider.MidiViewModel;
import cs3500.music.provider.ViewFactory;

/**
 * Represent the main that runs the program.
 */
public class MEMain {

  /**
   * Represent the main method for running the program.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      String songToPlay;
      String viewType;

      try {
        songToPlay = args[0];
        viewType = args[1];
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.print("No command line args given.");
        return;
      }

      // Build model
      IMusicEditorModel track = IMusicEditorModelBuilder.build(MusicEditorType.TRACK,
              new DiatonicScale(), 4).fromFile(songToPlay);

      IView view;
      IMusicEditorController controller;
      switch (viewType) {
        case "midi":
          view = ViewFactory.makeView("midi");
          //controller = new MidiMusicEditorController(model, provider);
          break;
        case "visual":
          view = ViewFactory.makeView("visual");
          //controller = new GuiMusicController(model, view2);
          break;
        case "console":
          view = ViewFactory.makeView("console");
          //controller = new ConsoleController(model, provider);
          break;
        case "guimidi":
          view = ViewFactory.makeView("audiovisual");
          //controller = new GuiMidiEditorController(model, view2);
          break;
        default:
          throw new IllegalArgumentException("Invalid provider type given: Must be \"midi\", "
                  + "\"visual\", or \"console\".");
      }

      controller = new MusicEditorController(track, view);

      // Gooooooooo
      controller.begin();
    } catch (FileNotFoundException e) {
      System.out.print("Given file not found.");
    }
  }

  static void print(String s) {
    System.out.print(s);
  }
}
