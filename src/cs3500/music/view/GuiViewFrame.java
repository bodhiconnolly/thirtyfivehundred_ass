package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * A class that visually displays a music model in Swing.
 */
public class GuiViewFrame extends JFrame implements IMusicEditorView {

  private GridControl.Grid grid;
  private int highestNote;
  private int lowestNote;
  private int numBeats;
  private int height;
  private JFrame window;


  /**
   * Creates new GuiView with size based on note range and length of track.
   */
  public GuiViewFrame(int highestNote, int lowestNote, int numBeats) {

    this.highestNote = highestNote;
    this.lowestNote = lowestNote;
    this.numBeats = numBeats;
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    height = this.highestNote - this.lowestNote;
    int width = this.numBeats;
    grid = new GridControl.Grid(width, height, this.lowestNote);
    grid.setSize();
    window = new JFrame();
    window.setSize(getPreferredSize());
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.add(new JScrollPane(grid,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    window.setVisible(true);
  }

  @Override
  public void renderNote(int rawpitch, int volume, int duration, int instrument, int beatNum) {
    for (int i = 1; i < duration - 1; ++i) {
      //render sustains
      grid.fillCell(beatNum + i, height - rawpitch, Color.GREEN);
    }
    //render first beat
    grid.fillCell(beatNum, height - rawpitch, Color.BLACK);
  }

  @Override
  public void setTempo(int tempo) {
    throw new UnsupportedOperationException("Can't set a tempo for this type of view.");
  }

  @Override
  public int getTempo() {
    throw new UnsupportedOperationException("No tempo for this type of view.");
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(800, 500);
  }
}
