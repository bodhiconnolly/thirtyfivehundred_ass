package cs3500.music.provider;

import java.awt.*;

import javax.swing.*;

/**
 * The panel that contains the visualization of the MIDI file.
 */
public class VisualViewMeasurePanel extends JPanel {
  private MidiViewModel viewModel;
  private int measure;

  /**
   * Constructor for VisualViewMeasurePanel.
   *
   * @param viewModel The provider model.
   */
  public VisualViewMeasurePanel(MidiViewModel viewModel) {
    this(viewModel, 16);
  }

  /**
   * Constructor for VisualViewMeasurePanel.
   *
   * @param viewModel The provider model.
   * @param measure   The amount of measures between each number.
   */
  public VisualViewMeasurePanel(MidiViewModel viewModel, int measure) {
    this.viewModel = viewModel;
    this.measure = measure;

    this.setPreferredSize(new Dimension(viewModel.getNumberOfBeats() * GuiViewImpl.NOTE_SIZE,
            GuiViewImpl.NOTE_SIZE));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //        g.setColor(this.TEXT_COLOR);
    for (int i = 0; i < this.viewModel.getNumberOfBeats(); i += 1) {
      if (i % this.measure == 0) {
        g.drawString("" + i, i * GuiViewImpl.NOTE_SIZE, (GuiViewImpl.NOTE_SIZE * 3) / 4);
      }
    }
  }
}