package cs3500.music.view;

import java.util.List;

/**
 * An adapter between the model and the view.
 */
public class MidiViewModel {
  private final IChart model;
  private int currentBeat;
  private boolean paused;

  /**
   * Constructor for MidiViewModel.
   *
   * @param model a model of a MIDI.
   */
  public MidiViewModel(IChart model) {
    this.model = model;
    this.currentBeat = 0;
    this.paused = false;
  }

  /**
   * Gets all of the notes at the specified beat.
   *
   * @param beat The beat to get the notes for.
   * @return The list of notes at the given beat.
   */
  public List<UnmodifiableNote> getNotesAtBeat(int beat) {
    return this.model.getAllNotes().get(beat);
  }

  /**
   * Returns the length of the song in beats.
   *
   * @return the length of this song
   */
  public int getNumberOfBeats() {
    return this.model.numberOfBeats();
  }

  /**
   * Returns the amount of pitches represented in this song.
   *
   * @return the amount of pitches
   */
  public int getNumberOfPitches() {
    return this.getMaxPitch() - this.getMinPitch() + 1;
  }

  /**
   * Gets the maximum pitch of this song.
   *
   * @return the max pitch of this song
   */
  public int getMaxPitch() {
    return this.model.getMaxPitch();
  }

  /**
   * Gets the minimum pitch of this song.
   *
   * @return the minimum pitch of this song.
   */
  public int getMinPitch() {
    return this.model.getMinPitch();
  }

  /**
   * Static method for determining the name for an integer pitch.
   *
   * @param pitch The pitch, between 0 and 127.
   * @return The name of the pitch.
   * @throws IllegalArgumentException if the pitch is invalid (not between 0 and 127.
   */
  public static String pitchToString(int pitch) throws IllegalArgumentException {
    if (pitch >= 0 && pitch <= 127) {
      String[] noteNames = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
      String name = noteNames[pitch % 12];
      // add the octave number
      return name + ((pitch / 12) - 1);
    } else {
      throw new IllegalArgumentException("Pitch must be between 0 and 127.");
    }
  }

  /**
   * Returns the tempo of this piece.
   *
   * @return model's tempo.
   */
  public int getTempo() {
    return model.getTempo();
  }

  /**
   * Returns the current beat of this piece.
   *
   * @return The current beat.
   */
  public int getCurrentBeat() {
    return this.currentBeat;
  }

  /**
   * Increments the current beat by 1.
   */
  public void incrementBeat() {
    this.currentBeat += 1;
  }

  /**
   * Toggles the pause flag.
   */
  public void playPause() {
    this.paused = !paused;
  }

  /**
   * Returns whether or not the paused flag is true.
   * @return whether or not the song is paused.
   */
  public boolean isPaused() {
    return this.paused;
  }
}


