package cs3500.music.model;

import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Receiver;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.sound.midi.VoiceStatus;

/**
 * Represents a mock of a MidiDevice Synthesizer for testing purposes.
 */
public class MidiSynthMock implements Synthesizer {
  StringBuilder sb;

  public MidiSynthMock(StringBuilder sb) {
    this.sb = sb;
  }

  @Override
  public Receiver getReceiver() throws MidiUnavailableException {
    this.sb.append("Receiver gotten\n");
    return new ReceiverMock(this.sb);
  }

  @Override
  public Info getDeviceInfo() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public void open() throws MidiUnavailableException {
    this.sb.append("Synth opened\n");
  }

  @Override
  public void close() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean isOpen() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public long getMicrosecondPosition() {
    return 0;
  }

  @Override
  public int getMaxReceivers() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public int getMaxTransmitters() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public List<Receiver> getReceivers() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public Transmitter getTransmitter() throws MidiUnavailableException {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public List<Transmitter> getTransmitters() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public int getMaxPolyphony() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public long getLatency() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public MidiChannel[] getChannels() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public VoiceStatus[] getVoiceStatus() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean isSoundbankSupported(Soundbank soundbank) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean loadInstrument(Instrument instrument) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public void unloadInstrument(Instrument instrument) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean remapInstrument(Instrument from, Instrument to) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public Soundbank getDefaultSoundbank() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public Instrument[] getAvailableInstruments() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public Instrument[] getLoadedInstruments() {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean loadAllInstruments(Soundbank soundbank) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public void unloadAllInstruments(Soundbank soundbank) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public boolean loadInstruments(Soundbank soundbank, Patch[] patchList) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }

  @Override
  public void unloadInstruments(Soundbank soundbank, Patch[] patchList) {
    throw new UnsupportedOperationException("Operation not supported by mock.");
  }
}
