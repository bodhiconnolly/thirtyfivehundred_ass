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
   *
   * @param volume
   * @param instrument
   * @param pitch
   * @param duration
   * @param head
   */
  public UnmodifiableNote(int volume, int instrument, int pitch, int duration, boolean head) {
    this.volume = volume;
    this.instrument = instrument;
    this.pitch = pitch;
    this.duration = duration;
    this.head = head;
  }

  /**
   *
   * @param pitch
   * @return
   */
  public int compareTo(int pitch) {
    return 0;
  }

  /**
   *
   * @return
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
   *
   * @return
   */
  public int getVolume() {
    return volume;
  }

  /**
   *
   * @return
   */
  public int getInstrument() {
    return instrument;
  }

  /**
   *
   * @return
   */
  public int getPitch() {
    return pitch;
  }

  /**
   *
   * @return
   */
  public int getDuration() {
    return duration;
  }

  /**
   *
   * @return
   */
  public boolean isHead() {
    return head;
  }
}
