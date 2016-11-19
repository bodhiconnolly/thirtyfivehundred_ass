package cs3500.music;

import java.io.FileNotFoundException;
import java.util.Scanner;

import cs3500.music.controller.ConsoleController;
import cs3500.music.controller.GuiMidiEditorController;
import cs3500.music.controller.GuiMusicController;
import cs3500.music.controller.IMusicEditorController;
import cs3500.music.controller.MidiMusicEditorController;
import cs3500.music.model.DiatonicScale;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.IMusicEditorModelBuilder;
import cs3500.music.model.MusicEditorType;
import cs3500.music.view.ConsoleView;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.MidiViewImpl;

/**
 * Represent the main that runs the program.
 */
public class MEMain {

  /**
   * Represent the main method for running the program.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // Take song name input (just here for fun, thus the reason we didn't waste our time putting
      // it into the controller and validating inputs)
      Scanner scanner = new Scanner(System.in);
      String songToPlay;
      String viewType;
//      try {
//        songToPlay = args[0];
//        viewType = args[1];
//      }
//      catch (ArrayIndexOutOfBoundsException e) {
//        System.out.print("No command line args given.");
//        return;
//      }
      songToPlay = scanner.next();
      viewType = scanner.next();

      // Build model
      IMusicEditorModel model = IMusicEditorModelBuilder.build(MusicEditorType.TRACK,
              new DiatonicScale(), 4).fromFile(songToPlay);

      IMusicEditorView view;
      IMusicEditorController controller;
      switch (viewType) {
        case "midi":
          view = new MidiViewImpl(model.getTempo());
          controller = new MidiMusicEditorController(model, view);
          break;
        case "visual":
          view = new GuiViewFrame(
                  model.getHighestNote(), model.getLowestNote(), model.length());
          controller = new GuiMusicController(model, view);
          break;
        case "console":
          view = new ConsoleView(model);
          controller = new ConsoleController(model, view);
          break;
        case "guimidi":
          view = new GuiViewFrame(
                  model.getHighestNote(), model.getLowestNote(), model.length());
          controller = new GuiMidiEditorController(model, view);
          break;
        default:
          throw new IllegalArgumentException("Invalid view type given: Must be \"midi\", "
                  + "\"visual\", or \"console\".");
      }

      // Gooooooooo
      controller.go();
    } catch (FileNotFoundException e) {
      System.out.print("Given file not found.");
    }
  }

  static void print(String s) {
    System.out.print(s);
  }
}