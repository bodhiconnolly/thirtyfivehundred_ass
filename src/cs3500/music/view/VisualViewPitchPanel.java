package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * The panel that contains the names of the pitches.
 */
public class VisualViewPitchPanel extends JPanel {
  private MidiViewModel viewModel;
  private final Color TEXT_COLOR = Color.BLACK;

  /**
   * Constructor for VisualViewPitchPanel.
   *
   * @param viewModel The view model.
   */
  public VisualViewPitchPanel(MidiViewModel viewModel) {
    this.viewModel = viewModel;
    this.setPreferredSize(new Dimension(GuiViewImpl.NOTE_SIZE * 2, GuiViewImpl.NOTE_SIZE
            * viewModel.getNumberOfPitches()));
  }

  @Override
  public void paintComponent(Graphics g) {
    g.setColor(this.TEXT_COLOR);
    for (int pitch = this.viewModel.getMaxPitch(); pitch >= this.viewModel.getMinPitch(); pitch
            -= 1) {
      g.drawString(MidiViewModel.pitchToString(pitch), 0, ((this.viewModel.getMaxPitch() - pitch)
              + 1) * GuiViewImpl.NOTE_SIZE + (GuiViewImpl.NOTE_SIZE));
    }
  }
}