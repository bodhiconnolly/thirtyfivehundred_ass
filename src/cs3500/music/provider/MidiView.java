package cs3500.music.provider;

import java.util.List;
import java.util.Objects;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import cs3500.music.model.UnmodifiableNote;

/**
 * A MidiView is an implementation of {@link IView} that plays a song as a MIDI.
 */
public class MidiView implements IView {
  private final Synthesizer synth;
  private final Receiver receiver;
  private int timing;

  /**
   * Default Constructor for MidiView.
   */
  public MidiView() {
    Receiver receiver1;
    Synthesizer synth1;
    try {
      synth1 = MidiSystem.getSynthesizer();
      receiver1 = synth1.getReceiver();
      synth1.open();
    } catch (MidiUnavailableException e) {
      synth1 = null;
      receiver1 = null;
      e.printStackTrace();
    }
    this.synth = Objects.requireNonNull(synth1);
    this.receiver = Objects.requireNonNull(receiver1);
  }

  /**
   * Constructor for testing MidiView.
   */
  public MidiView(Synthesizer mock) {
    Receiver receiver1;
    Synthesizer synth1;
    try {
      synth1 = mock;
      receiver1 = synth1.getReceiver();
      synth1.open();
    } catch (MidiUnavailableException e) {
      synth1 = null;
      receiver1 = null;
      e.printStackTrace();
    }
    this.synth = Objects.requireNonNull(synth1);
    this.receiver = Objects.requireNonNull(receiver1);
  }

  @Override
  public void run(MidiViewModel viewModel) {
    try {
      timing = viewModel.getTempo() / 1000;
      for (int t = 0; t < viewModel.getNumberOfBeats(); t++) {
        while (viewModel.isPaused()) {
          Thread.sleep(1);
        }
        viewModel.incrementBeat();
        List<UnmodifiableNote> notes = viewModel.getNotesAtBeat(t);
        for (UnmodifiableNote n : notes) {
          if (n.isHead()) {
            playNote(n, t);
          }
        }
        Thread.sleep(timing);
      }
    } catch (InvalidMidiDataException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synth.close();
    return;
  }

  private void playNote(UnmodifiableNote n, int time) throws InvalidMidiDataException {
    MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, n.getInstrument() - 1, n.getPitch(),
            n.getVolume());
    MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, n.getInstrument() - 1, n.getPitch(),
            n.getVolume());
    this.receiver.send(start, time);
    this.receiver.send(stop, timing * (time + n.getDuration() - 1));
  }
}
