package cs3500.music.view;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import cs3500.music.controller.KeyboardHandler;

/**
 * A class for visualising a song and playing it simultaneously.
 */
public class CompositeView implements GuiView {
  private GuiView guiView;
  private MidiViewImpl midiView;
  private ArrayList<ArrayList<Note>> notes;
  private int endOfSong;
  private int curBeat; // Current position in playback of song
  private boolean playing; // Whether or not song is playing

  /**
   * Initialize view class with two view classes.
   *
   * @param guiView  the visual class.
   * @param midiView the midi class.
   */
  public CompositeView(GuiView guiView, MidiViewImpl midiView) {
    this.guiView = guiView;
    this.midiView = midiView;
    this.notes = new ArrayList<>();
    notes.add(new ArrayList<>());
    this.endOfSong = 0;
    this.curBeat = 0;
    this.playing = false;
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    if (rawPitch == -1 && volume == -1 && duration == -1 && instrument == -1 && beatnum == -1) {
      // Render the notes in the composite view as midi sounds. Advance the red line in the gui
      // view for each beat.

      if (!playing) {
        playing = true;
      } else {
        playing = false;
        return;
      }

      for (int i = curBeat; i < notes.size() && playing; i++) {
        for (int j = 0; j < notes.get(i).size(); j++) {
          Note n = notes.get(i).get(j);
          this.midiView.renderNote(n.rawPitch, n.volume, n.duration, n.instrument, n.beatnum);
        }
        setBeat(curBeat);
        curBeat = curBeat + 1;
        try {
          Thread.sleep(this.getTempo() / 1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      // Keep advancing the red line on the gui view
      while (curBeat <= endOfSong && playing) {
        setBeat(curBeat);
        curBeat = curBeat + 1;
        try {
          Thread.sleep(this.getTempo() / 1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    } else {
      // Update end of song if necessary
      if (endOfSong < beatnum + duration) {
        endOfSong = beatnum + duration;
      }
      int lowestNote = guiView.getLowestNote();
      guiView.renderNote(rawPitch - lowestNote - 12, 1, duration, instrument, beatnum);
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

  @Override
  public void keyboardCallback(KeyboardHandler handler) {
    guiView.keyboardCallback(handler);
  }

  @Override
  public void setBeat(int beat) {
    this.guiView.setBeat(beat);
  }

  @Override
  public void scroll(int toScroll) {
    // Scroll is taken care of automatically here.
    throw new InvalidParameterException("Scroll is automatic in this view");
  }

  @Override
  public int getLowestNote() {
    return 0;
  }

  @Override
  public String getTextInput() {
    return null;
  }

  @Override
  public void update(boolean noteChange) {
    // Scroll is taken care of automatically here.
    throw new InvalidParameterException("Update is automatic in this view");
  }

  /**
   * Representation of a note for use in the composite view. Doesn't use the same represenation
   * as in the model to keep them decoupled. Notes could have been represented as a list of ints
   * or as a series of lists of ints, but this seems more comprehensible. Created it as a private
   * inner class because it doesn't need to be used nor should it be used anywhere other than in
   * the CompositeView class.
   */
  private class Note {
    int rawPitch;
    int volume;
    int duration;
    int instrument;
    int beatnum;

    Note(int rawPitch, int volume, int duration, int instrument, int beatnum) {
      this.rawPitch = rawPitch;
      this.volume = volume;
      this.duration = duration;
      this.instrument = instrument;
      this.beatnum = beatnum;
    }
  }
}
