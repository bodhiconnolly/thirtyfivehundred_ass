package cs3500.music.view;

import org.junit.Test;

import cs3500.music.model.DiatonicScale;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.Track;

import static org.junit.Assert.*;

/**
 * Created by Bodhi on 7/11/2016.
 */
public class ConsoleViewTest {

  @Test
  public void addNotes() {
    IMusicEditorModel track = new Track(new DiatonicScale(), 4);
    track.addNote(2, 1, 1, 3, 0);
    track.addNote(3, 2, 3, 2, 0);
    track.addNote(4, 2, 7, 3, 0);
    assertEquals(track.toString(), "   C#1   D1  D#1   E1   F1  F#1   G1  " +
            "G#1   A1  A#1   B1   C2  C#2   D2  D#2 \n" +
            " 0                                                                           \n"
            + " 1  X                                                                        \n"
            + " 2  |                                                                        \n"
            + " 3  |                                                                X       \n"
            + " 4                                                                   |       \n"
            + " 5                                                                           \n"
            + " 6                                                                           \n"
            + " 7                                                                        X  \n"
            + " 8                                                                        |  \n"
            + " 9                                                                        |  \n"
            + "10                                                                           \n");
  }



}