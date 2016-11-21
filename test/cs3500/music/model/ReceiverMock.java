package cs3500.music.model;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 * Represents a mock of a receiver for use in testing.
 */
class ReceiverMock implements Receiver {
  private StringBuilder sb;

  ReceiverMock(StringBuilder sb) {
    this.sb = sb;
  }

  @Override
  public void send(MidiMessage message, long timeStamp) {
    ShortMessage sm = (ShortMessage)message; // Casted as a ShortMessage for testing purposes
    sb.append("Sent message: ");
    int intCmd = sm.getCommand();
    String sCmd;
    if (intCmd == 144) {
      sCmd = "ON";
    }
    else if (intCmd == 128) {
      sCmd = "OFF";
    }
    else {
      sCmd = "Other";
    }
    sb.append("Command:    " + sCmd + "\n");
    sb.append("              " + "Instrument: " + sm.getChannel() + "\n");
    sb.append("              " + "Pitch:      " + sm.getData1() + "\n");
    sb.append("              " + "Velocity:   " + sm.getData2() + "\n");
    sb.append("              " + "Time Stamp: " + timeStamp + "\n");

  }

  @Override
  public void close() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }
}
