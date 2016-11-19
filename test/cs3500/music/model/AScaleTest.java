package cs3500.music.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Represent tests for cs3500.music.model.AScale.
 */
public class AScaleTest {
  DiatonicScale dScale = new DiatonicScale();
  ArrayList<Integer> testDiatonicPitches = new ArrayList<Integer>();
  ArrayList<Integer> diatonicPitches = new ArrayList<Integer>();

  void init() {
    testDiatonicPitches.add(1);
    testDiatonicPitches.add(2);
    testDiatonicPitches.add(3);
    testDiatonicPitches.add(4);
    testDiatonicPitches.add(5);
    testDiatonicPitches.add(6);
    testDiatonicPitches.add(7);
    testDiatonicPitches.add(8);
    testDiatonicPitches.add(9);
    testDiatonicPitches.add(10);
    testDiatonicPitches.add(11);
    testDiatonicPitches.add(12);

    for (int i : dScale.pitches) {
      diatonicPitches.add(i);
    }
  }

  // Test that building a diatonic scale works properly
  @Test
  public void testBuildDiatonic() {
    this.init();
    assertEquals(diatonicPitches, testDiatonicPitches);
  }
}