package cs3500.music.view;

/**
 * Created by matteoalampi on 11/30/16.
 */
public class UnmodifiableNote {
  private int volume;
  private int instrument;
  private int pitch;
  private int duration;
  private boolean head;

  public UnmodifiableNote(int volume, int instrument, int pitch, int duration, boolean head) {
    this.volume = volume;
    this.instrument = instrument;
    this.pitch = pitch;
    this.duration = duration;
    this.head = head;
  }

  public int compareTo(int pitch) {
    return 0;
  }

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

  public int getVolume() {
    return volume;
  }

  public int getInstrument() {
    return instrument;
  }

  public int getPitch() {
    return pitch;
  }

  public int getDuration() {
    return duration;
  }

  public boolean isHead() {
    return head;
  }
}
