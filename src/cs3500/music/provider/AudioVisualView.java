package cs3500.music.provider;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * An AudioVisualView is an implementation of {@link IView} that displays a song in a Swing visual,
 * as well as playing it as a midi.
 */
public class AudioVisualView implements GuiView {
  private MidiView midiView;
  private GuiViewImpl visualView;

  public AudioVisualView() {
    this.midiView = new MidiView();
    this.visualView = new GuiViewImpl();
  }

  @Override
  public void run(MidiViewModel viewModel) {
    this.visualView.run(viewModel);

    refresh(onTick, viewModel.getTempo() / 1000);

    this.midiView.run(viewModel);
  }

  /**
   * Runs the given runnable every interval of timeout.
   *
   * @param r       the runnable to run
   * @param timeout the time between each run
   */
  private void refresh(Runnable r, int timeout) {
    new Thread(() -> {
      while (true) {
        r.run();
        try {
          Thread.sleep(timeout);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  @Override
  public void refresh() {
    visualView.refresh();
  }

  private Runnable onTick = () -> {
    this.visualView.refresh();
  };


  @Override
  public void pausePlay() {
    visualView.pausePlay();
  }

  @Override
  public void goToStart() {
    visualView.goToStart();
  }

  @Override
  public void goToEnd() {
    visualView.goToEnd();
  }

  @Override
  public void scrollLeft() {
    visualView.scrollLeft();
  }

  @Override
  public void scrollRight() {
    visualView.scrollRight();
  }

  @Override
  public void addKeyListener(KeyListener keyListener) {
    visualView.addKeyListener(keyListener);
  }

  @Override
  public void addMouseListener(MouseListener mouseListener) {
    visualView.addMouseListener(mouseListener);
  }

  @Override
  public int getMousePitch() throws IllegalArgumentException {
    return this.visualView.getMousePitch();
  }

  @Override
  public int getMouseBeat() throws IllegalArgumentException {
    return this.visualView.getMouseBeat();
  }
}