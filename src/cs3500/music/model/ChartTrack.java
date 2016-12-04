package cs3500.music.model;

import java.util.ArrayList;

import cs3500.music.view.IChart;
import cs3500.music.view.UnmodifiableNote;

/**
 * Created by matteoalampi on 12/3/16.
 */
public class ChartTrack implements IChart {
  IMusicEditorModel track;

  public ChartTrack(IMusicEditorModel track) {
    this.track = track;
  }


  @Override
  public int numberOfBeats() {
    return track.length();
  }

  @Override
  public int getMaxPitch() {
    return track.getHighestNote();
  }

  @Override
  public int getMinPitch() {
    return track.getLowestNote();
  }

  @Override
  public int getTempo() {
    return track.getTempo();
  }

  @Override
  public ArrayList<ArrayList<UnmodifiableNote>> getAllNotes() {
    ArrayList<ArrayList<UnmodifiableNote>> notes = new ArrayList<>();
    for (int i = 0; i < track.length(); i++) {
      notes.add(new ArrayList<>());
      for (ANote n : track.getAtBeat(i)) {
        if (n.whichType() == INoteType.NOTE) {
          UnmodifiableNote convertedNote = new UnmodifiableNote(90, 1, n.getPitch() + ((n.getBaseInterval() - 1) * 12), n.getDuration(), true);
          notes.get(notes.size() - 1).add(convertedNote);
        }
        else if (n.whichType() == INoteType.SUSTAIN){
          UnmodifiableNote convertedNote = new UnmodifiableNote(90, 1, n.getPitch() + ((n.getBaseInterval() - 1) * 12), n.getDuration(), false);
          notes.get(notes.size() - 1).add(convertedNote);
        }
        else {
          UnmodifiableNote convertedNote = new UnmodifiableNote(0, 1, 0, 0, false);
          notes.get(notes.size() - 1).add(convertedNote);
        }
      }
    }
    return notes;
  }
}
