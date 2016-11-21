package cs3500.music.view;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.*;

import cs3500.music.controller.KeyboardHandler;

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
  private KeyListener keyListener;
  private boolean justScrolled = false;
  private JScrollPane scroller;
  private JFrame window;
  private JTextField input;
  private JPanel panel;

  /**
   * Creates new GuiView.
   */
  public GuiViewFrame(int highestNote, int lowestNote, int numBeats, boolean editable) {

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
    window = new JFrame();
    window.setSize(getPreferredSize());
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel();
    panel.setLayout(new FlowLayout());
    input = new JTextField(15);
    if (editable) {
      panel.add(input);
    }
    panel.add(grid);

    scroller = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    window.add(scroller);
    window.setVisible(true);

  }

  /**
   * Render note.
   *
   * @param rawpitch   pitch
   * @param volume     volume of note
   * @param duration   Duration of note
   * @param instrument instr
   * @param beatNum    beat
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

  @Override
  public void setBeat(int num) {
    JScrollBar vertical = this.scroller.getHorizontalScrollBar();
    Rectangle r = window.getBounds();
    int w = r.width;
    int pixelsSinceScroll = grid.setBeat(num, justScrolled);
    if (pixelsSinceScroll > w - 80) {
      vertical.setValue(vertical.getValue() + w - 40);
      justScrolled = true;
    } else {
      justScrolled = false;
    }
  }

  @Override
  public void keyboardCallback(KeyboardHandler handler) {
    keyListener = handler;
    input.addKeyListener(keyListener);
    input.setFocusable(true);
  }

  @Override
  public void scroll(int toScroll) {
    JScrollBar vertical = this.scroller.getHorizontalScrollBar();
    vertical.setValue(vertical.getValue() + toScroll);
  }

  @Override
  public int getLowestNote() {
    return this.lowestNote;
  }

  @Override
  public String getTextInput() {
    String command = this.input.getText();
    this.input.setText("");
    return command;
  }

  @Override
  public void update(boolean noteChange) {
    if (noteChange) {
      grid.resetNotes();
    }
    grid.repaint();
  }
}