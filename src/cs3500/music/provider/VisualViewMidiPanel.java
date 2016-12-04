package cs3500.music.provider;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs3500.music.model.UnmodifiableNote;

/**
 * The panel that contains the visualization of the MIDI file.
 */
public class VisualViewMidiPanel extends JPanel {
  // The color for the head of a note
  private final Color HEAD_COLOR = Color.BLUE;
  // The color for the tail of a note
  private final Color TAIL_COLOR = Color.CYAN;
  // The color for the lines separating the notes
  private final Color LINE_COLOR = Color.BLACK;

  private MidiViewModel viewModel;
  private int measure;

  private int height;
  private int width;

  private int scrollTime = 0;


  /**
   * Constructor for VisualViewMidiPanel.
   *
   * @param viewModel The provider model.
   */
  public VisualViewMidiPanel(MidiViewModel viewModel) {
    this(viewModel, 4);
  }

  /**
   * Constructor for VisualViewMidiPanel.
   *
   * @param viewModel The provider model.
   * @param measure   The amount of notes in a measure.
   */
  public VisualViewMidiPanel(MidiViewModel viewModel, int measure) {
    this.viewModel = viewModel;
    this.measure = measure;

    this.width = GuiViewImpl.NOTE_SIZE * this.viewModel.getNumberOfBeats();
    this.height = GuiViewImpl.NOTE_SIZE * (this.viewModel.getNumberOfPitches());

    this.setPreferredSize(new Dimension(this.width, this.height + GuiViewImpl.NOTE_SIZE));
  }

  @Override
  public void paintComponent(Graphics g) {
    // Handle the default painting
    super.paintComponent(g);

    // Draws notes
    for (int beat = 0; beat < this.viewModel.getNumberOfBeats(); beat += 1) {
      List<UnmodifiableNote> notes = this.viewModel.getNotesAtBeat(beat);
      for (UnmodifiableNote note : notes) {
        if (note.isHead()) {
          g.setColor(this.HEAD_COLOR);
        } else {
          g.setColor(this.TAIL_COLOR);
        }
        g.fillRect(beat * GuiViewImpl.NOTE_SIZE, (this.viewModel.getNumberOfPitches() - (note
                .getPitch() - this.viewModel.getMinPitch()) - 1) * GuiViewImpl.NOTE_SIZE,
                GuiViewImpl.NOTE_SIZE, GuiViewImpl.NOTE_SIZE);
      }
    }

    g.setColor(this.LINE_COLOR);

    // Draws the outer box for the notes
    g.drawRect(0, 0, this.width, this.height);

    // Draws measure lines
    for (int i = this.measure; i < this.viewModel.getNumberOfBeats(); i += this.measure) {
      g.drawLine(i * GuiViewImpl.NOTE_SIZE, 0, i * GuiViewImpl.NOTE_SIZE, this.height);
    }

    // Draws lines between pitches
    for (int pitch = 0; pitch < this.viewModel.getNumberOfPitches(); pitch += 1) {
      g.drawLine(0, pitch * GuiViewImpl.NOTE_SIZE, this.width, pitch * GuiViewImpl.NOTE_SIZE);
    }

    // Draws red line at current beat
    g.setColor(Color.RED);
    g.drawLine(this.viewModel.getCurrentBeat() * GuiViewImpl.NOTE_SIZE,
            0,
            this.viewModel.getCurrentBeat() * GuiViewImpl.NOTE_SIZE,
            this.height);
  }

  /**
   * Refreshes the visual provider.
   */
  protected void refresh() {
    if (!this.viewModel.isPaused()) {
      scrollTime += 1;
    }
    this.validate();
    this.repaint();
  }

  /**
   * Returns true if the frame needs to scroll.
   * @param width the width of the frame.
   * @return true if the red line is out of provider.
   */
  public boolean needToScroll(int width) {
    boolean res = scrollTime * GuiViewImpl.NOTE_SIZE >= width;
    if (res) {
      scrollTime = 0;
    }
    return res;
  }
}