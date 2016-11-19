package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by matteoalampi on 11/19/16.
 */
public class CompositeView implements IMusicEditorView {
  GuiView guiView;
  MidiViewImpl midiView;
  ArrayList<ArrayList<Note>> notes;

  public CompositeView(GuiView guiView, MidiViewImpl midiView) {
    this.guiView = guiView;
    this.midiView = midiView;
    this.notes = new ArrayList<>();
    notes.add(new ArrayList<>());
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    if (rawPitch == -1 && volume == -1 && duration == -1 && instrument == -1 && beatnum == -1) {
      System.out.print("\nStarted MIDI rendering.");
      int songLength = this.notes.size();
      int curBeat = 0;
      for (ArrayList<Note> aln : notes) {
        // Uncomment the following line to print notes to the console as it is played (for fun!)
        //System.out.print(getString(notesAtBeat) + "\n");
        System.out.print("\nNew beat.\n");

        for (Note n : aln) {
          System.out.print("N");
          this.midiView.renderNote(n.rawPitch, n.volume, n.duration, n.instrument, n.beatnum);
        }
        //System.out.print("\nRendered notes in beat.");
        curBeat = curBeat + 1;
        try {
          System.out.print("\nGoing to sleep...");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.print("\nWoke up.");
        // Wait for last note to end
        if (curBeat >= songLength) {
          try {
            Thread.sleep(800);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return;
        }
      }
    }
    else {
      //guiView.renderNote(rawPitch, volume, duration, instrument, beatnum);
      int beatsToAdd = (beatnum + 1) - notes.size();
      for (int i = 0; i < beatsToAdd; i++) {
        notes.add(new ArrayList<>());
      }
      notes.get(beatnum).add(new Note(rawPitch, volume, duration, instrument, beatnum));
    }
  }

  @Override
  public void setTempo(int tempo) {
    midiView.setTempo(tempo);
  }

  @Override
  public int getTempo() {
    return midiView.getTempo();
  }

  class Note {
    int rawPitch;
    int volume;
    int duration;
    int instrument;
    int beatnum;

    Note (int rawPitch, int volume, int duration, int instrument, int beatnum) {
      this.rawPitch = rawPitch;
      this.volume = volume;
      this.duration = duration;
      this.instrument = instrument;
      this.beatnum = beatnum;
    }
  }
}
