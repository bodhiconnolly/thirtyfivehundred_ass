package cs3500.music;

import java.io.FileNotFoundException;

import javax.swing.text.View;

import cs3500.music.controller.IMusicEditorController;
import cs3500.music.model.ChartTrack;
import cs3500.music.model.DiatonicScale;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.IMusicEditorModelBuilder;
import cs3500.music.model.MusicEditorType;
import cs3500.music.view.ConsoleView;
import cs3500.music.view.GuiView;
import cs3500.music.view.IChart;
import cs3500.music.view.IView;
import cs3500.music.view.MidiViewModel;
import cs3500.music.view.ViewFactory;
import javafx.scene.chart.Chart;

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
      IChart chartTrack = new ChartTrack(track);
      MidiViewModel midiViewModel = new MidiViewModel(chartTrack);

      IView view;
      IMusicEditorController controller;
      switch (viewType) {
        case "midi":
          view = ViewFactory.makeView("midi");
          //controller = new MidiMusicEditorController(model, view);
          break;
        case "visual":
          view = ViewFactory.makeView("visual");
          //controller = new GuiMusicController(model, view2);
          break;
        case "console":
          view = ViewFactory.makeView("console");
          //controller = new ConsoleController(model, view);
          break;
        case "guimidi":
          view = ViewFactory.makeView("audiovisual");
          //controller = new GuiMidiEditorController(model, view2);
          break;
        default:
          throw new IllegalArgumentException("Invalid view type given: Must be \"midi\", "
                  + "\"visual\", or \"console\".");
      }

      // Gooooooooo
      //controller.begin();
      view.run(midiViewModel);
    } catch (FileNotFoundException e) {
      System.out.print("Given file not found.");
    }
  }

  static void print(String s) {
    System.out.print(s);
  }
}
