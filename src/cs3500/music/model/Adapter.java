package cs3500.music.model;

import java.util.ArrayList;

/**
 * A class that takes one of our model objects and implements the provider's
 * model interface, so that we can interface with their view code.
 */
public class Adapter implements IChart {
  IMusicEditorModel track;

  public Adapter(IMusicEditorModel track) {
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
    // Initialize the grid of unmodifiable notes
    ArrayList<ArrayList<UnmodifiableNote>> notes = new ArrayList<>();
    // Copy notes and rests from track over to new grid of unmodifiable notes
    for (int i = 0; i < track.length(); i++) {
      notes.add(new ArrayList<>());
      for (ANote n : track.getAtBeat(i)) {
        if (n.whichType() == INoteType.NOTE) {
          UnmodifiableNote convertedNote = new UnmodifiableNote(90, n.getInstrument(), n.getPitch() + ((n.getBaseInterval() - 1) * 12), n.getDuration() - 1, true);
          notes.get(notes.size() - 1).add(convertedNote);
        } else {
          UnmodifiableNote convertedNote = new UnmodifiableNote(0, 1, 0, 0, false);
          notes.get(notes.size() - 1).add(convertedNote);
        }
      }
    }
    // Run through grid of unmodifiable notes and add sustains based on the durations of existing
    // notes
    for (int i = 0; i < notes.size(); i++) {
      for (int j = 0; j < notes.get(0).size(); j++) {
        UnmodifiableNote thisNote = notes.get(i).get(j);
        if (thisNote.isHead()) {
          for (int k = 1; k < thisNote.getDuration(); k++) {
            if (!notes.get(i + k).get(j).isHead()) { // Prevent overwriting note heads
              notes.get(i + k).set(j, new UnmodifiableNote(90, 1, thisNote.getPitch(), thisNote.getDuration(), false));
            }
          }
        }
        notes.get(i).set(j, new UnmodifiableNote(thisNote.getVolume(), thisNote.getInstrument(), thisNote.getPitch(), thisNote.getDuration() + 4, thisNote.isHead()));
      }
    }
    return notes;
  }
}