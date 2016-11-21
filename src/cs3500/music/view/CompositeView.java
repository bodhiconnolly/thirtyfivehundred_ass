package cs3500.music.view;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import cs3500.music.controller.KeyboardHandler;

/**
 * A class for visualising a song and playing it simultaneously.
 */
public class CompositeView implements GuiView {
  GuiView guiView;
  MidiViewImpl midiView;
  ArrayList<ArrayList<Note>> notes;

  /**
   * Initialize view class with two view classes.
   * @param guiView the visual class.
   * @param midiView the midi class.
   */
  public CompositeView(GuiView guiView, MidiViewImpl midiView) {
    this.guiView = guiView;
    this.midiView = midiView;
    this.notes = new ArrayList<>();
    notes.add(new ArrayList<>());
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    if (rawPitch == -1 && volume == -1 && duration == -1 && instrument == -1 && beatnum == -1) {
      int curBeat = 0;
      for (ArrayList<Note> aln : notes) {
        for (Note n : aln) {
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
      try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
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

  class Note {
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
