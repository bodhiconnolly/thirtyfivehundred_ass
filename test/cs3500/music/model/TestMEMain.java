package cs3500.music.model;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import cs3500.music.controller.GuiMusicController;
import cs3500.music.controller.IMusicEditorController;
import cs3500.music.controller.MidiMusicEditorController;
import cs3500.music.view.GuiView;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.MidiViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Represent main.
 */
public class TestMEMain {
  @Test
  public void testMidiView() {
    try {
      StringBuilder sb = new StringBuilder();
      // Take song name input (just here for fun, thus the reason we didn't waste our time putting
      // it into the controller and validating inputs)
      Scanner scanner = new Scanner(System.in);
      String songToPlay = "mary-little-lamb";
      String viewType = "midi";
      // Build model
      IMusicEditorModel model = IMusicEditorModelBuilder.build(MusicEditorType.TRACK,
              new DiatonicScale(), 4).fromFile(songToPlay);

      IMusicEditorView view;
      GuiView view2;
      IMusicEditorController controller;
      switch (viewType) {
        case "midi":
          view = new MidiViewImpl(model.getTempo(), new MidiSynthMock(sb));
          controller = new MidiMusicEditorController(model, view);
          break;
        case "visual":
          view2 = new GuiViewFrame(
                  model.getHighestNote(), model.getLowestNote(), model.length(), true);
          controller = new GuiMusicController(model, view2);
          break;
        case "console":
          throw new IllegalArgumentException("Yall didn't implement this yet.");
        default:
          throw new IllegalArgumentException("Invalid view type given: Must be \"midi\", "
                  + "\"visual\", or \"console\".");
      }

      // Gooooooooo
      controller.begin();

      assertEquals(sb.toString(), this.sbTest.toString());
    } catch (FileNotFoundException e) {
      System.out.print("Given file not found.");
    }
  }

  StringBuilder sbTest = new StringBuilder("Receiver gotten\n"
          + "Synth opened\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1000000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      79\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      79\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      79\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      79\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1000000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      67\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      76\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      74\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 600000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      64\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      64\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n"
          + "Sent message: Command:    ON\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: -1\n"
          + "Sent message: Command:    OFF\n"
          + "              Instrument: 0\n"
          + "              Pitch:      72\n"
          + "              Velocity:   90\n"
          + "              Time Stamp: 1800000\n");
}
