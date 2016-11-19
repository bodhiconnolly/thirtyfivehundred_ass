package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends JFrame implements GuiView {

  //private final JPanel displayPanel; // You may want to refine this to a subtype of JPanel
  private GridControl.Grid grid;
  private int highestNote;
  private int lowestNote;
  private int numBeats;
  private int height;

  /**
   * Creates new GuiView.
   */
  public GuiViewFrame(int highestNote, int lowestNote, int numBeats) {

    this.highestNote = highestNote;
    this.lowestNote = lowestNote;
    this.numBeats = numBeats;

    //this.displayPanel = new ConcreteGuiViewPanel();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    height = this.highestNote - this.lowestNote;
    int width = this.numBeats;
    //this.getContentPane().setLayout(new BorderLayout());
    grid = new GridControl.Grid(width, height, this.lowestNote);
    grid.setSize();
    JFrame window = new JFrame();
    window.setSize(getPreferredSize());
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    window.setVisible(true);

  }

  /**
   * Render note.
   * @param rawpitch pitch
   * @param volume volume of note
   * @param duration Duration of note
   * @param instrument instr
   * @param beatNum beat
   */
  public void renderNote(int rawpitch, int volume, int duration, int instrument, int beatNum) {
    for (int i = 1; i < duration; ++i) {
      //render sustains
      grid.fillCell(beatNum + i, height - rawpitch, Color.GREEN);
    }
    //render first note
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
