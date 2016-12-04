package cs3500.music.provider;

/**
 * A View is a way of rendering a MIDI, whether it be playing it as audio or drawing it on the
 * screen.
 */
public interface IView {
  /**
   * Display this provider in whatever way it is supposed to.
   */
  void run(MidiViewModel viewModel);
}
