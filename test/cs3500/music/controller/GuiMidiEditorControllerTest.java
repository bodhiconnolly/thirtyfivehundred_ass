package cs3500.music.controller;

import org.junit.Test;

import java.io.FileNotFoundException;

import cs3500.music.model.DiatonicScale;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.IMusicEditorModelBuilder;
import cs3500.music.model.MusicEditorType;
import cs3500.music.view.CompositeView;
import cs3500.music.view.GuiView;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.IMusicEditorView;
import cs3500.music.view.MidiViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * A class for testing the composite controller.
 */
public class GuiMidiEditorControllerTest {

  IMusicEditorModel model = IMusicEditorModelBuilder.build(MusicEditorType.TRACK, new DiatonicScale(),
          4).fromFile("mary-little-lamb.txt");
  GuiView view = new CompositeView(new GuiViewFrame(
          model.getHighestNote(), model.getLowestNote(), model.length(), false),
          new MidiViewImpl(model.getTempo()));
  IMusicEditorController controller = new GuiMidiEditorController(model, view);

  /**
   * Tests for confirming that go modifies the model and view properly.
   */
  @Test
  public void testGo() {
    controller.go();
    assertEquals(67, model.getHighestNote());
    assertEquals(52, model.getLowestNote());
    assertEquals(200000, model.getTempo());
    assertEquals(66, model.length());
  }

  /**
   * Catch the error above.
   * @throws FileNotFoundException
   */
  public GuiMidiEditorControllerTest() throws FileNotFoundException {
    System.out.print("Houston, we have a problem.");
  }
}