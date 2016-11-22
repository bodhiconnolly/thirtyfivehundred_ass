package cs3500.music.model;

import org.junit.Test;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

import static junit.framework.TestCase.assertEquals;


/**
 * Test the cs3500.music.music editor cs3500.music.model.
 */
public class MusicEditorModelTest {
  Track track;
  AScale diatonicScale;

  void init() {
    diatonicScale = new DiatonicScale();
    track = new Track(diatonicScale, 4);
  }

  @Test
  public void testGetTrackString() {
    this.init();
    track.addNote(1, 1, 0, 1, 0);
    track.addNote(2, 1, 1, 1, 0);
    track.addNote(3, 1, 2, 2, 0);

    track.addNote(2, 1, 0, 4, 0);
    track.addNote(3, 1, 0, 1, 0);
    //memTrack.addNote(1, 1, 1, 1);
    track.addNote(3, 1, 1, 1, 0);
    //memTrack.addNote(1, 1, 2, 1);
    track.addNote(2, 1, 2, 1, 0);
    track.addNote(3, 1, 2, 1, 0);
    track.addNote(5, 1, 0, 1, 0);
    track.addNote(6, 1, 0, 2, 0);
    track.addNote(7, 1, 0, 3, 0);
    track.addNote(8, 1, 0, 4, 0);
    track.addNote(9, 1, 0, 5, 0);
    track.addNote(10, 1, 0, 6, 0);
    track.addNote(11, 1, 0, 7, 0);
    track.addNote(12, 1, 0, 8, 0);
    track.addNote(1, 2, 0, 9, 0);
    track.addNote(2, 2, 0, 11, 0);
    track.addNote(2, 1, 5, 2, 0);
    track.addNote(3, 1, 5, 3, 0);
    track.addNote(3, 2, 5, 3, 0);
    track.addNote(5, 2, 5, 8, 0);
    track.editDuration(2, 5, 2, 5, 0);
    track.editStartBeat(2, 5, 2, 5, 0);
    track.editPitchBaseInterval(4, 1, 3, 1, 5, 0);
    track.deleteNote(1, 1, 0, 0);
    track.deleteNote(5, 2, 2, 0);
    track.deleteNote(2, 2, 0, 0);
    String trackString = track.toString();

    //String trackString = mem.getTrackString();
    System.out.print(trackString);

    assertEquals("   C1  C#1   D1  D#1   E1   F1  F#1   G1  G#1   A1  A#1   B1   C2 \n"
            + "0  X    X    X         X    X    X    X    X    X    X    X    X  \n"
            + "1  X    |    X              |    |    |    |    |    |    |    |  \n"
            + "2  X    X    X                   |    |    |    |    |    |    |  \n"
            + "3                                     |    |    |    |    |    |  \n"
            + "4                                          |    |    |    |    |  \n"
            + "5                                               |    |    |    |  \n"
            + "6                                                    |    |    |  \n"
            + "7                                                         |    |  \n"
            + "8                                                              |  \n", trackString);


    try {
      StringBuilder sb = new StringBuilder();

      MidiMessage mm = new ShortMessage(ShortMessage.NOTE_ON, 1, 2, 3);
      ShortMessage sm = (ShortMessage)mm;

      sb.append("Sent message: ");
      sb.append("Command:    " + sm.getCommand() + "\n");
      sb.append("              " + "Instrument: " + sm.getChannel() + "\n");
      sb.append("              " + "Pitch:      " + sm.getData1() + "\n");
      sb.append("              " + "Velocity:   " + sm.getData2() + "\n");
      System.out.print("\n\n" + sb);

    } catch (InvalidMidiDataException e) {
      e.printStackTrace();
    }
  }
}