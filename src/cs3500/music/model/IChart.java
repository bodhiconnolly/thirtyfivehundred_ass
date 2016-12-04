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
   *
   * @return
   */
  int numberOfBeats();

  /**
   *
   * @return
   */
  int getMaxPitch();

  /**
   *
   * @return
   */
  int getMinPitch();

  /**
   *
   * @return
   */
  int getTempo();

  /**
   *
   * @return
   */
  ArrayList<ArrayList<UnmodifiableNote>> getAllNotes();
}
