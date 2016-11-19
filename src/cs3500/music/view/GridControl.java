package cs3500.music.view;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import cs3500.music.model.DiatonicScale;

public class GridControl {

  /**
   * Grid that is controller.
   */
  public static class Grid extends JPanel {

    private List<Point> fillCellsBlack;
    private List<Point> fillCellsGreen;

    private int xSize;
    private int ySize;
    private int lowestNote;

    private int sideLength = 20;

    public Grid(int xSize, int ySize, int lowestNote) {
      this.xSize = xSize;
      this.ySize = ySize;
      this.lowestNote = lowestNote;
      fillCellsBlack = new CopyOnWriteArrayList<Point>();
      fillCellsGreen = new CopyOnWriteArrayList<Point>();
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;


      for (Point fillCell : fillCellsGreen) {
        int cellX = sideLength * 2 + (fillCell.x * sideLength);
        int cellY = sideLength + (fillCell.y * sideLength);
        g.setColor(Color.GREEN);
        g.fillRect(cellX, cellY, sideLength, sideLength);
      }
      for (Point fillCell : fillCellsBlack) {
        int cellX = sideLength * 2 + (fillCell.x * sideLength);
        int cellY = sideLength + (fillCell.y * sideLength);
        g.setColor(Color.BLACK);
        g.fillRect(cellX, cellY, sideLength, sideLength);
      }
      g.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(2));
      g.drawRect(sideLength * 2, sideLength, (xSize) * sideLength, (ySize + 1) * sideLength);
      g2.setStroke(new BasicStroke(1));
      //vertical
      for (int i = sideLength * 2; i <= (xSize + 2) * sideLength; i += sideLength) {
        if ((i / sideLength - 2) % 4 == 0) {
          g2.setStroke(new BasicStroke(2));
          g.drawLine(i, sideLength, i, (ySize + 2) * sideLength);
        } else {
          g2.setStroke(new BasicStroke(2));
        }
      }
      //horizontal
      for (int i = sideLength; i <= (ySize + 2) * sideLength; i += sideLength) {
        if ((i / sideLength) % 4 == 0) {
          g.drawLine(sideLength * 2, i, (xSize + 2) * sideLength, i);
        } else {
          g.drawLine(sideLength * 2, i, (xSize + 2) * sideLength, i);
        }
      }
      drawLabels(g);
    }

    private void drawLabels(Graphics g) {
      for (int i = 0; i < xSize; ++i) {
        if (i % 16 == 0) {
          g.drawString(Integer.toString(i),
                  (i + 2) * sideLength, sideLength * 3 / 4);
        }
      }
      for (int i = 0; i < ySize + 1; ++i) {
        int j = ySize - i;
        g.drawString((new DiatonicScale().toString(
                (lowestNote + j) % 12 + 1)
                        + Integer.toString((lowestNote + j) / 12 - 1)),
                0, (int) (sideLength * (i + 1.7)));
      }
    }

    public void fillCell(int x, int y, Color c) {
      if (c == Color.BLACK) {
        fillCellsBlack.add(new Point(x, y));
      } else {
        fillCellsGreen.add(new Point(x, y));
      }
      repaint();
    }

    public void setSize() {
      super.setPreferredSize(
              new Dimension(sideLength * (xSize + 3),
                      sideLength * (ySize + 3)));
    }

  }
}