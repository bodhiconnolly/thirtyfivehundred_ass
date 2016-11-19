package cs3500.music.model;

/**
 * Represent a rest. Represented as a class both in case it needs properties in the future
 * and because positions in a track can be represented by a cs3500.music.model.Note or cs3500.music.model.Sustain (as well as a cs3500.music.model.Rest),
 * so rest needs to implement cs3500.music.model.ANote.
 */
class Rest extends ANote {
  /**
   * Constructs a rest.
   */
  Rest() {
    // Empty because a rest doesn't have any fields.
  }

  @Override
  public int getPitch() {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have a pitch.");
  }

  @Override
  public int getBaseInterval() {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: "
            + "A rest does not have a base interval.");
  }

  @Override
  public int getBeat() {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have a beat.");
  }

  @Override
  public int getDuration() {
    return 1;
  }

  @Override
  void changePitch(int newPitch, AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have a pitch.");
  }

  @Override
  void changeBaseInterval(int newBaseInterval, AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: "
            + "A rest does not have a base interval.");
  }

  @Override
  void changeBeat(int newBeat, AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have a beat.");
  }

  @Override
  void changeDuration(int newDuration, AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest's duration cannot be changed.");
  }

  @Override
  public INoteType whichType() {
    return INoteType.REST;
  }

  @Override
  public int getRawPitchNumber(AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have a raw pitch"
            + "number.");
  }

  @Override
  public int getInstrument() {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest does not have an "
            + "instrument.");
  }

  public String toString(AScale scale) {
    throw new IllegalArgumentException("Invalid cs3500.music.model.ANote given: A rest cannot be converted to a "
            + "conventional form string.");
  }

  public String toString() {
    return "     ";
  }
}
