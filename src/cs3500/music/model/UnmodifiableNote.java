package cs3500.music.model;

/**
 *  Intermediate note class to give notes to view without access to whole model.
 *  Added in HW8 to match provider.
 */
public class UnmodifiableNote {
  private int volume;
  private int instrument;
  private int pitch;
  private int duration;
  private boolean head;

  /**
   * Constructs a new note.
   * @param volume volume.
   * @param instrument instrument.
   * @param pitch pitch.
   * @param duration duration.
   * @param head is the note a start note.
   */
  public UnmodifiableNote(int volume, int instrument, int pitch, int duration, boolean head) {
    this.volume = volume;
    this.instrument = instrument;
    this.pitch = pitch;
    this.duration = duration;
    this.head = head;
  }

  /**
   * Compare notes.
   * @param pitch the pitches.
   * @return the relative note.
   */
  public int compareTo(int pitch) {
    return 0;
  }

  /**
   * Get string of note.
   * @return the note string.
   */
  public String asString() {
    if (this.head) {
      return "  X  ";
    }
    else if (pitch > 0) {
      return "  |  ";
    }
    else {
      return "     ";
    }
  }

  /**
   * Get volume of note.
   * @return the volume.
   */
  public int getVolume() {
    return volume;
  }

  /**
   * Get instrument number.
   * @return instrument number.
   */
  public int getInstrument() {
    return instrument;
  }

  /**
   * Get the pitch.
   * @return the pitch.
   */
  public int getPitch() {
    return pitch;
  }

  /**
   * Get the duration.
   * @return duration.
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Check whether note is head.
   * @return boolean for is head.
   */
  public boolean isHead() {
    return head;
  }
}
