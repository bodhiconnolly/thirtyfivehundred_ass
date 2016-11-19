package cs3500.music.view;

import javax.sound.midi.*;

/**
 * A skeleton for MIDI playback
 */
public class MidiViewImpl implements IMusicEditorView {
  private Synthesizer synth;
  private Receiver receiver;
  private int tempo;

  public MidiViewImpl(int tempo) {
    try {
      this.synth = MidiSystem.getSynthesizer();
      this.receiver = synth.getReceiver();
      this.synth.open();
      this.tempo = tempo;
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void renderNote(int rawPitch, int volume, int duration, int instrument, int beatnum) {
    try {
      this.playNote(rawPitch, volume, duration, instrument);
    }
    catch (InvalidMidiDataException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

  @Override
  public int getTempo() {
    return this.tempo;
  }

  void playNote(int rawPitch, int velocity, int duration, int instrument) throws InvalidMidiDataException {
    MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, instrument - 1, rawPitch, velocity);
    MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, instrument - 1, rawPitch, velocity);
    this.receiver.send(start, -1);
    this.receiver.send(stop, this.synth.getMicrosecondPosition() + duration * this.tempo);
  }

}
