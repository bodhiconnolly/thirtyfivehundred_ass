package cs3500.music.model;

import java.util.ArrayList;

/**
 * Represent a track interface, added in HW8 to match provider.
 * Models a song as a collection of notes (containing pitch, base interval (ex. octave),
 * and duration) which begin at specific beats (time steps). Provides methods for adding, accessing,
 * and editing notes. Additionally, provides methods for getting information about the track, such
 * as the highest note, lowest note, and tempo (which can be edited).
 * Columns represent all notes at a beat, rows represent all notes
 * of a particular pitch/base interval.
 */
public interface IChart {
  /**
   * Get total length of song.
   * @return number of beats in song.
   */
  int numberOfBeats();

  /**
   * Get highest pitch in song.
   * @return highest pitch.
   */
  int getMaxPitch();

  /**
   * Get lowest pitch.
   * @return lowest pitch.
   */
  int getMinPitch();

  /**
   * Get tempo.
   * @return tempo as milliseconds of a beat.
   */
  int getTempo();

  /**
   * Get list of notes
   * @return 2d array list of notes.
   */
  ArrayList<ArrayList<UnmodifiableNote>> getAllNotes();
}
