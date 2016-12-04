package cs3500.music.view;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.*;


/**
 * A GUIViewImpl is an implementation of {@link GuiView} that displays a song in a Swing visual.
 */
public class GuiViewImpl implements GuiView {
  private JFrame frame = new JFrame();
  private JScrollPane scrollableChart;
  private MidiViewModel vm;
  private VisualViewMidiPanel midiPanel;
  private boolean autoScroll;
  private MouseListener mouseListener;

  @Override
  public void run(MidiViewModel viewModel) {
    vm = viewModel;
    this.autoScroll = true;
    frame.setLayout(new BorderLayout());
    JPanel measurePanel = new VisualViewMeasurePanel(viewModel);
    this.midiPanel = new VisualViewMidiPanel(viewModel);

    JPanel innerScrollable = new JPanel(new BorderLayout());
    innerScrollable.add(measurePanel, BorderLayout.PAGE_START);
    innerScrollable.add(midiPanel, BorderLayout.CENTER);

    scrollableChart = new JScrollPane(innerScrollable);
    scrollableChart.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    frame.getContentPane().add(scrollableChart, BorderLayout.CENTER);

    JPanel pitchPanel = new VisualViewPitchPanel(viewModel);
    frame.getContentPane().add(pitchPanel, BorderLayout.LINE_START);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    midiPanel.addMouseListener(this.mouseListener);

    frame.pack();

    frame.setVisible(true);
  }

  @Override
  public void refresh() {
    if (autoScroll && midiPanel.needToScroll(frame.getWidth())) {
      scrollableChart.getHorizontalScrollBar().setValue(vm.getCurrentBeat() * NOTE_SIZE);
    }
    this.midiPanel.refresh();
  }

  @Override
  public void pausePlay() {
    this.vm.playPause();
  }

  @Override
  public void goToStart() {
    // you probably don't want the view to jump away on its own
    this.autoScroll = false;
    scrollableChart.getHorizontalScrollBar().setValue(0);
  }

  @Override
  public void goToEnd() {
    // you probably don't want the view to jump away on its own
    this.autoScroll = false;
    scrollableChart.getHorizontalScrollBar().setValue(vm.getNumberOfBeats() * NOTE_SIZE
            - frame.getWidth());
  }

  @Override
  public void scrollLeft() {
    // you probably don't want the view to jump away on its own
    this.autoScroll = false;
    int currentScroll = scrollableChart.getHorizontalScrollBar().getValue();
    int scrollBy = (vm.getNumberOfBeats() / 16) * NOTE_SIZE;
    scrollableChart.getHorizontalScrollBar().setValue(currentScroll - scrollBy);
  }

  @Override
  public void scrollRight() {
    this.autoScroll = false;
    int currentScroll = scrollableChart.getHorizontalScrollBar().getValue();
    int scrollBy = (vm.getNumberOfBeats() / 16) * NOTE_SIZE;
    scrollableChart.getHorizontalScrollBar().setValue(currentScroll + scrollBy);
  }

  @Override
  public void addKeyListener(KeyListener keyListener) {
    this.frame.addKeyListener(keyListener);
  }

  @Override
  public void addMouseListener(MouseListener mouseListener) {
    this.mouseListener = mouseListener;
  }

  @Override
  public int getMousePitch() throws IllegalArgumentException {
    if (Objects.isNull(this.midiPanel.getMousePosition())) {
      throw new IllegalArgumentException("Mouse is out of bounds.");
    }
    return this.vm.getMaxPitch()
            - ((int) this.midiPanel.getMousePosition().getY() / NOTE_SIZE);
  }

  @Override
  public int getMouseBeat() throws IllegalArgumentException {
    if (Objects.isNull(this.midiPanel.getMousePosition())) {
      throw new IllegalArgumentException("Mouse is out of bounds.");
    }
    return (int) this.midiPanel.getMousePosition().getX() / NOTE_SIZE;
  }
}